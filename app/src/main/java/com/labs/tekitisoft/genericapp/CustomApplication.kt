package com.labs.tekitisoft.genericapp

import android.app.Application
import com.labs.tekitisoft.genericapp.di.components.AppComponent
import com.labs.tekitisoft.genericapp.di.components.DaggerAppComponent

/**
 * Created by francisco.dominguez on 13/04/18.
 */
class CustomApplication: Application(){

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = initAppComponent(this)
    }

    private fun initAppComponent(app: CustomApplication): AppComponent =
            DaggerAppComponent.builder()
                    //.appModule(AppModule(app))
                    .build()

}