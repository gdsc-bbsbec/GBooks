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

package com.gdsc.bbsbec.booksapi.model

import kotlin.collections.ArrayList

data class Books(
    val totalItems: Int,
    val items: ArrayList<Items>
)

data class Items(
    val id: String,
    val volumeInfo: VolumeInfo,
    val saleInfo: SaleInfo,
    val accessInfo: AccessInfo,
    val searchInfo: SearchInfo
)

data class VolumeInfo(
    val title: String,
    val subtitle: String,
    val authors: ArrayList<String>,
    val publisher: String,
    val publishedDate: String,
    val description: String,
    val pageCount: Int,
    val printType: String,
    val Categories: ArrayList<String>,
    val imageLinks: ImageLinks,
    val language: String,
    val previewLink: String,
    val infoLink: String
)

data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String
)

data class SaleInfo(
    val country: String,
    val saleability: String,
    val isEbook: Boolean,
    val listPrice: ListPrice,
    val buyLink: String
)

data class ListPrice(
    val amount: Double,
    val currencyCode: String
)

data class AccessInfo(
    val pdf: PDF,
    val webReaderLink: String
)

data class PDF(
    val isAvailable: Boolean
)

data class SearchInfo(
    val textSnippet: String
)
