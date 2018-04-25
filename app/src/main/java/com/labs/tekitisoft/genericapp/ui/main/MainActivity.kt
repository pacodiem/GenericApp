package com.labs.tekitisoft.genericapp.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.labs.tekitisoft.genericapp.R
import com.labs.tekitisoft.genericapp.ui.artistHome.ArtistPagerFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by francisco.dominguez on 05/04/18.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Setting green theme defined in styles.xml
        setTheme(R.style.AppThemeGreen)

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Attaching the fragment to the main container
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainerZero, ArtistPagerFragment.createInstance())
                    .commit()
        }

        initToolbar()

        //title = getString(R.string.app_name)

        //var presenter = ArtistListPresenter()

        //presenter.getTopArtists()
    }


    private fun initToolbar() {
        //val mToolbar = findViewById<View>(R.id.toolbar) as Toolbar   //No needed thanks to Kotlinx import
        setSupportActionBar(toolbar)
        title = getString(R.string.app_name)
        toolbar.setTitleTextColor(resources.getColor(android.R.color.white))
    }

}
