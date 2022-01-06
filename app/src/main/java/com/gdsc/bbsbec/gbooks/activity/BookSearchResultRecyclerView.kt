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

package com.gdsc.bbsbec.gbooks.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdsc.bbsbec.gbooks.adapter.BookSearchResultAdapter
import com.gdsc.bbsbec.gbooks.databinding.ActivityBookSearchResultRecyclerViewBinding
import com.gdsc.bbsbec.gbooks.model.BookSearchResultData

class BookSearchResultRecyclerView : AppCompatActivity() {

    private lateinit var binding: ActivityBookSearchResultRecyclerViewBinding

    private var pass: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookSearchResultRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Search Results"

        val id: ArrayList<String> =
            intent.getStringArrayListExtra("id") as ArrayList<String>
        val bookName: ArrayList<String> =
            intent.getStringArrayListExtra("bookName") as ArrayList<String>
        val bookPublisher: ArrayList<String> =
            intent.getStringArrayListExtra("publisher") as ArrayList<String>
        val bookSmallThumbnail: ArrayList<String> =
            intent.getStringArrayListExtra("bookSmallThumbnail") as ArrayList<String>
        val bookThumbnail: ArrayList<String> =
            intent.getStringArrayListExtra("bookThumbnail") as ArrayList<String>
        val bookDescription: ArrayList<String> =
            intent.getStringArrayListExtra("bookDescription") as ArrayList<String>
        val previewLink: ArrayList<String> =
            intent.getStringArrayListExtra("previewLink") as ArrayList<String>

        val data = arrayListOf<BookSearchResultData>()
        repeat(bookName.size - 1) {
            data.add(
                BookSearchResultData(
                    id[pass],
                    bookSmallThumbnail[pass],
                    bookName[pass],
                    bookPublisher[pass],
                    bookDescription[pass],
                    previewLink[pass],
                    bookThumbnail[pass],
                )
            )
            pass += 1
        }

        val bookSearchResultAdapter = BookSearchResultAdapter(data) {
            val intent = Intent(this, BookDetailsActivity::class.java)
            intent.putExtra("id", it.id)
            intent.putExtra("bookName", it.title)
            intent.putExtra("bookPublisher", it.publisher)
            intent.putExtra("bookDescription", it.bookDescription)
            intent.putExtra("previewLink", it.previewLink)
            intent.putExtra("bookThumbnail", it.bookThumbnail)
            startActivity(intent)
        }
        binding.bookSearchResultRecyclerView.adapter = bookSearchResultAdapter
        binding.bookSearchResultRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}