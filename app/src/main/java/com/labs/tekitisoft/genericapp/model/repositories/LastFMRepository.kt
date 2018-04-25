package com.labs.tekitisoft.genericapp.model.repositories

import com.labs.tekitisoft.genericapp.model.entities.LastFMTopArtists
import com.labs.tekitisoft.genericapp.model.services.LastFMService
import io.reactivex.Single

/**
 * Created by francisco.dominguez on 09/04/18.
 */
class LastFMRepository(val lastFMService: LastFMService){

    fun getTopArtists(page : Int = 1, limit : Int = 30) : Single<LastFMTopArtists> {
        return lastFMService.getTopArtists(page, limit)
    }

}