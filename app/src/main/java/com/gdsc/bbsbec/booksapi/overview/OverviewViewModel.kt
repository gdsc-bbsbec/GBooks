/*
 * Copyright (C) 2021 Google Developer Student Clubs BBSBEC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gdsc.bbsbec.booksapi.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdsc.bbsbec.booksapi.network.BooksApi
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status

    /**
     * Call getBooksList() on init so we can display status immediately.
     */
    init {
        getBooksList()
    }

    /**
     * Gets Books Status information from the Google Books API Retrofit service and updates the
     * [Books] [List] [LiveData].
     */
    private fun getBooksList() {
        try {
            viewModelScope.launch {
                val listResult = BooksApi.retrofitService.getBooks()
                _status.value = listResult
            }
        } catch (e: Exception) {
            _status.value = "Failure: ${e.message}"
        }
    }
}