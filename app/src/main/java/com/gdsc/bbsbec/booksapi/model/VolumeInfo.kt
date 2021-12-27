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

import com.google.gson.annotations.SerializedName


data class VolumeInfo(

    @SerializedName("title") var title: String? = null,
    @SerializedName("subtitle") var subtitle: String? = null,
    @SerializedName("authors") var authors: ArrayList<String> = arrayListOf(),
    @SerializedName("publisher") var publisher: String? = null,
    @SerializedName("publishedDate") var publishedDate: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("industryIdentifiers") var industryIdentifiers: ArrayList<IndustryIdentifiers> = arrayListOf(),
    @SerializedName("readingModes") var readingModes: ReadingModes? = ReadingModes(),
    @SerializedName("pageCount") var pageCount: Int? = null,
    @SerializedName("printType") var printType: String? = null,
    @SerializedName("categories") var categories: ArrayList<String> = arrayListOf(),
    @SerializedName("averageRating") var averageRating: Double? = null,
    @SerializedName("ratingsCount") var ratingsCount: Int? = null,
    @SerializedName("maturityRating") var maturityRating: String? = null,
    @SerializedName("allowAnonLogging") var allowAnonLogging: Boolean? = null,
    @SerializedName("contentVersion") var contentVersion: String? = null,
    @SerializedName("panelizationSummary") var panelizationSummary: PanelizationSummary? = PanelizationSummary(),
    @SerializedName("imageLinks") var imageLinks: ImageLinks? = ImageLinks(),
    @SerializedName("language") var language: String? = null,
    @SerializedName("previewLink") var previewLink: String? = null,
    @SerializedName("infoLink") var infoLink: String? = null,
    @SerializedName("canonicalVolumeLink") var canonicalVolumeLink: String? = null

)