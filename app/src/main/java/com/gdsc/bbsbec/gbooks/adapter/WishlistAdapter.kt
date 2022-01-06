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

package com.gdsc.bbsbec.gbooks.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gdsc.bbsbec.gbooks.R
import com.gdsc.bbsbec.gbooks.model.BookSearchResultData
import kotlinx.android.synthetic.main.book_wishlist_row.view.*

class WishlistAdapter(private val listener: DeleteBookInterface) :
    RecyclerView.Adapter<WishlistAdapter.MyViewHolder>() {

    private var bookList = emptyList<BookSearchResultData>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.book_wishlist_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = bookList[position]
        holder.itemView.book_name.text = currentItem.title
        holder.itemView.book_publisher.text = currentItem.publisher
        holder.itemView.delete_image_view.setOnClickListener {
            listener.onClick(bookList[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    fun setData(book: List<BookSearchResultData>) {
        this.bookList = book
        notifyDataSetChanged()
    }

    interface DeleteBookInterface {
        fun onClick(book: BookSearchResultData)
    }
}