package com.labs.tekitisoft.genericapp.di.modules

import com.labs.tekitisoft.genericapp.model.repositories.LastFMRepository
import com.labs.tekitisoft.genericapp.model.services.LastFMService
import com.labs.tekitisoft.genericapp.ui.artistList.ArtistListPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by francisco.dominguez on 13/04/18.
 */
@Module
class PresenterModule{

    @Provides
    //@Singleton // As this presenter is used twice it cannot be singleton

    fun providesArtistListPresenter(lastFMRepository: LastFMRepository): ArtistListPresenter = ArtistListPresenter(lastFMRepository)
}