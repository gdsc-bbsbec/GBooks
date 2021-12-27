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

package com.gdsc.bbsbec.booksapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gdsc.bbsbec.booksapi.databinding.ActivityMainBinding
import com.gdsc.bbsbec.booksapi.repository.Repository
import com.gdsc.bbsbec.booksapi.utils.Constants.Companion.API_KEY

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.getButton.setOnClickListener {
            val title: String = binding.editText.text.toString()
            viewModel.getBooks(title, API_KEY)
            viewModel.myResponse.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    Log.d("Response", response.body().toString())
                    response.body()!!.items.forEach() {
/*                    Log.d(
                        "Response",
                        response.body()!!.items[1].saleInfo!!.listPrice!!.amount.toString()
                    */
                        Log.d("Response", it.volumeInfo!!.title.toString())
                        Log.d("Response", it.volumeInfo!!.subtitle.toString())
                        Log.d("Response", it.volumeInfo!!.publisher.toString())
                        Log.d("Response", it.volumeInfo!!.publishedDate.toString())
                        Log.d("Response", it.saleInfo!!.listPrice!!.amount.toString())
                        Log.d(
                            "Response",
                            it.saleInfo!!.listPrice!!.currencyCode.toString()
                        )
                        Log.d("Response", "----------------------------")
                    }
                } else {
                    Log.d("Response", response.errorBody().toString())
                }
            })
        }
    }
}