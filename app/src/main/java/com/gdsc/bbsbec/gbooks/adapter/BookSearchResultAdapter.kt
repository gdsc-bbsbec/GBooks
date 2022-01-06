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

package com.gdsc.bbsbec.gbooks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.gdsc.bbsbec.gbooks.databinding.ActivityBookSearchResultBinding
import com.gdsc.bbsbec.gbooks.model.BookSearchResultData

class BookSearchResultAdapter(
    private val data: ArrayList<BookSearchResultData>,
    private val onClick: (BookSearchResultData) -> Unit
) :
    RecyclerView.Adapter<BookSearchResultAdapter.BookSearchResultViewHolder>() {

    inner class BookSearchResultViewHolder(private val item: ActivityBookSearchResultBinding) :
        RecyclerView.ViewHolder(item.root) {
        fun bindData(bookSearchResultData: BookSearchResultData) {
            // Attach data to item
            item.bookNameTextView.text = bookSearchResultData.title
            item.publisherNameTextView.text = bookSearchResultData.publisher
            item.bookSmallThumbnail.load(bookSearchResultData.bookSmallThumbnail)
            item.searchResult.apply {
                setOnClickListener {
                    onClick(bookSearchResultData)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookSearchResultViewHolder {
        return BookSearchResultViewHolder(
            ActivityBookSearchResultBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BookSearchResultViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}