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


data class AccessInfo(

    @SerializedName("country") var country: String? = null,
    @SerializedName("viewability") var viewability: String? = null,
    @SerializedName("embeddable") var embeddable: Boolean? = null,
    @SerializedName("publicDomain") var publicDomain: Boolean? = null,
    @SerializedName("textToSpeechPermission") var textToSpeechPermission: String? = null,
    @SerializedName("epub") var epub: Epub? = Epub(),
    @SerializedName("pdf") var pdf: Pdf? = Pdf(),
    @SerializedName("webReaderLink") var webReaderLink: String? = null,
    @SerializedName("accessViewStatus") var accessViewStatus: String? = null,
    @SerializedName("quoteSharingAllowed") var quoteSharingAllowed: Boolean? = null

)