package com.labs.tekitisoft.genericapp.di.modules

import com.labs.tekitisoft.genericapp.model.repositories.LastFMRepository
import com.labs.tekitisoft.genericapp.model.services.LastFMService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by francisco.dominguez on 16/04/18.
 */
@Module
class ServiceModule{

    @Provides
    @Singleton
    fun providesLastFMRepository(lastFMService: LastFMService) : LastFMRepository = LastFMRepository(lastFMService)

    @Provides
    @Singleton
    fun providesLastFMService() : LastFMService = LastFMService.create()
}