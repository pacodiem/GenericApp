package com.labs.tekitisoft.genericapp.model.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by francisco.dominguez on 10/04/18.
 */
data class LastFMTopArtists(
        @SerializedName("artists") val topArtists: LastFMArtistList
)