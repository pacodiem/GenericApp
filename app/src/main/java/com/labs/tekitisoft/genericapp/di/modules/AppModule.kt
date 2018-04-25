package com.labs.tekitisoft.genericapp.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by francisco.dominguez on 13/04/18.
 */
@Module
class AppModule(private val app: Application){

    @Provides
    @Singleton
    fun provideContext(): Context = app

}