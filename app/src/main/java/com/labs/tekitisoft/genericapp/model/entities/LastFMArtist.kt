package com.labs.tekitisoft.genericapp.model.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

/**
 * Created by francisco.dominguez on 09/04/18.
 */
@Parcelize
data class LastFMArtist(
        val name: String,
        val playcount: Long,
        val listeners: Long,
        val mbid: String,
        val url: String,
        @SerializedName("image")  val images: @RawValue List<LastFMImage>
) : Parcelable