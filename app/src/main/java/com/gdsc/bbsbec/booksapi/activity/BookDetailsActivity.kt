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

package com.gdsc.bbsbec.booksapi.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import coil.load
import com.gdsc.bbsbec.booksapi.databinding.ActivityBookDetailsBinding

class BookDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookThumbnail: String = intent.getStringExtra("bookThumbnail").toString()
        val bookName: String = intent.getStringExtra("bookName").toString()
        val bookPublisher: String = intent.getStringExtra("bookPublisher").toString()
        val bookDescription: String = intent.getStringExtra("bookDescription").toString()
        val previewLink: String = intent.getStringExtra("previewLink").toString()

        binding.bookName.text = bookName
        binding.publisherNameTextView.text = bookPublisher
        binding.bookDescription.text = bookDescription
        binding.bookThumbnail.load(bookThumbnail)

        binding.previewButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(previewLink)
            startActivity(intent)
        }
    }
}