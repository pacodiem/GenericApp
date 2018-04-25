package com.labs.tekitisoft.genericapp.di.components

import com.labs.tekitisoft.genericapp.di.modules.AppModule
import com.labs.tekitisoft.genericapp.di.modules.PresenterModule
import com.labs.tekitisoft.genericapp.di.modules.ServiceModule
import com.labs.tekitisoft.genericapp.ui.artistList.ArtistListFragment
import com.labs.tekitisoft.genericapp.ui.artistList.ArtistListPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by francisco.dominguez on 13/04/18.
 */
@Singleton
@Component(modules = [AppModule::class/*, PresenterModule::class*/, ServiceModule::class])

interface AppComponent{

    fun plus() : ArtistListComponent

    fun inject(target: ArtistListPresenter)

    //fun inject(target: ArtistListFragment)
}