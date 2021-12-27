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


data class Items(

    @SerializedName("kind") var kind: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("etag") var etag: String? = null,
    @SerializedName("selfLink") var selfLink: String? = null,
    @SerializedName("volumeInfo") var volumeInfo: VolumeInfo? = VolumeInfo(),
    @SerializedName("saleInfo") var saleInfo: SaleInfo? = SaleInfo(),
    @SerializedName("accessInfo") var accessInfo: AccessInfo? = AccessInfo(),
    @SerializedName("searchInfo") var searchInfo: SearchInfo? = SearchInfo()

)
