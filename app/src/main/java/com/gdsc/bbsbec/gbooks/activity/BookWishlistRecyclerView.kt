/*
 * Copyright (C) 2022 Google Developer Student Clubs BBSBEC
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


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdsc.bbsbec.gbooks.adapter.WishlistAdapter
import com.gdsc.bbsbec.gbooks.databinding.ActivityBookWishlistRecyclerViewBinding
import com.gdsc.bbsbec.gbooks.model.BookSearchResultData
import com.gdsc.bbsbec.gbooks.viewmodel.BookDataViewModel

class BookWishlistRecyclerView : AppCompatActivity(), WishlistAdapter.DeleteBookInterface {

    private lateinit var binding: ActivityBookWishlistRecyclerViewBinding
    private lateinit var mBookDataViewModel: BookDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookWishlistRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Wishlist"

        // Recyclerview
        val wishlistAdapter = WishlistAdapter(this)
        binding.bookWishListRecyclerView.adapter = wishlistAdapter
        binding.bookWishListRecyclerView.layoutManager = LinearLayoutManager(this)

        // BookDataViewModel
        mBookDataViewModel = ViewModelProvider(this).get(BookDataViewModel::class.java)
        mBookDataViewModel.readAllData.observe(this, Observer { book ->
            wishlistAdapter.setData(book)
        })
    }

    override fun onClick(book: BookSearchResultData) {
        mBookDataViewModel.deleteBook(book)
        Toast.makeText(applicationContext, "Book removed from wishlist", Toast.LENGTH_LONG)
            .show()
    }
}