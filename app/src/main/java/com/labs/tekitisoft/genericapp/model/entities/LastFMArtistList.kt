package com.labs.tekitisoft.genericapp.model.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by francisco.dominguez on 09/04/18.
 */
class LastFMArtistList(
        @SerializedName("artist") val artists: List<LastFMArtist>
)
