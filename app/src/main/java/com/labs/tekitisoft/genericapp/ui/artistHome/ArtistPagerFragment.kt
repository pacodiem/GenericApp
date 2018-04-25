package com.labs.tekitisoft.genericapp.ui.artistHome

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.labs.tekitisoft.genericapp.R
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.labs.tekitisoft.genericapp.ui.artistList.ArtistListFragment
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_band_pager.*

/**
 * Created by francisco.dominguez on 05/04/18.
 *  Contains the pager fragment which will held the Fragment list
 */
class ArtistPagerFragment : Fragment(){

    companion object {
        fun createInstance() = ArtistPagerFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
        = inflater!!.inflate(R.layout.fragment_band_pager, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPagerAndTabs(view)
    }

    private fun initViewPagerAndTabs(view : View) {
        // use childFragmentManager instead normal fragment manager to change viewPager fragment successfully
        val pagerAdapter = ArtistPagerAdapter(childFragmentManager)

        pagerAdapter.addFragment(ArtistListFragment.createInstance("Rock"), getString(R.string.tab_1))
        pagerAdapter.addFragment(ArtistListFragment.createInstance("Indie"), getString(R.string.tab_2))

        viewPager.adapter = pagerAdapter
        val parentView = view.parent.parent as CoordinatorLayout
        parentView.tabLayout.setupWithViewPager(viewPager)
    }
}