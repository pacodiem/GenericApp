package com.labs.tekitisoft.genericapp.ui.artistHome

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by francisco.dominguez on 06/04/18.
 */
class ArtistPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private val fragmentList = mutableListOf<Fragment>()
    private val fragmentTitleList = mutableListOf<String>()


    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

    override fun getItem(position: Int): Fragment
            = fragmentList[position]


    override fun getCount(): Int
        = fragmentList.size


    override fun getPageTitle(position: Int): CharSequence
        = fragmentTitleList.get(position)
}