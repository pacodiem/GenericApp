package com.labs.tekitisoft.genericapp.di.components

import com.labs.tekitisoft.genericapp.di.modules.PresenterModule
import com.labs.tekitisoft.genericapp.di.modules.ServiceModule
import com.labs.tekitisoft.genericapp.ui.artistList.ArtistListFragment
import com.labs.tekitisoft.genericapp.ui.artistList.ArtistListPresenter
import dagger.Subcomponent

/**
 * Created by francisco.dominguez on 16/04/18.
 */
@Subcomponent(modules = [PresenterModule::class])

interface ArtistListComponent{
    fun presenter(): ArtistListPresenter
}