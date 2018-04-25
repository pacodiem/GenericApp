package com.labs.tekitisoft.genericapp.ui.artistList

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionInflater
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.labs.tekitisoft.genericapp.CustomApplication
import com.labs.tekitisoft.genericapp.R
import com.labs.tekitisoft.genericapp.di.modules.PresenterModule
import com.labs.tekitisoft.genericapp.model.entities.LastFMArtist
import kotlinx.android.synthetic.main.item_band.view.*
import kotlinx.android.synthetic.main.fragment_band_list.view.*
import com.labs.tekitisoft.genericapp.ui.artistDetail.ArtistDetailFragment
import javax.inject.Inject

/**
 * Created by francisco.dominguez on 05/04/18.
 */
class ArtistListFragment : Fragment(), ArtistListContract.ArtistListView{


    private val component by lazy { (activity.application as CustomApplication).appComponent.plus() }
    private val presenter: ArtistListPresenter by lazy { component.presenter() } // With subComponent injection
    //@Inject lateinit var presenter : ArtistListPresenter   //With normal component injection
    private lateinit var listName : String
    private lateinit var rootView : View
    private var artistList: List<LastFMArtist>? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Indicate that objects will be injected
        //(activity.application as CustomApplication).appComponent.inject(this) //With normal component injection
        rootView = inflater!!.inflate(R.layout.fragment_band_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.listName = arguments.getString(ARG_LIST_NAME)
        rootView.band_list.layoutManager = LinearLayoutManager(context)

        presenter.setView(this)

        if (artistList == null) {
            if (listName == "Rock") {
                presenter.showTopArtists()
            } else {
                presenter.showTopArtists(3)
            }
        } else {
            rootView.band_list.adapter = ArtistListAdapter(listName, artistList!!, {itemView: View, artist:LastFMArtist -> itemClicked(itemView, artist)})
        }
    }

    override fun setTopListArtists(artistList : List<LastFMArtist>){
        this.artistList = artistList
    }

    override fun setAdapter(listArtist : List<LastFMArtist>){
        rootView.band_list.adapter = ArtistListAdapter(listName, listArtist, {itemView: View, artist:LastFMArtist -> itemClicked(itemView, artist)})
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun itemClicked(holderView: View, artist: LastFMArtist) {
        val bandDetailFragment = ArtistDetailFragment.newInstance(artist)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Defining the transition to be used
            val detTransition = TransitionInflater.from(context).inflateTransition(R.transition.shared_element_transition)
            // Setting the shared element transition
            bandDetailFragment.setSharedElementEnterTransition(detTransition)
            bandDetailFragment.setEnterTransition(Fade())
            exitTransition = Fade()
            // Setting the return shared element transition
            bandDetailFragment.setSharedElementReturnTransition(detTransition)
        }

        activity.supportFragmentManager // use this instead normal fragment manager to change viewPager successfully
                .beginTransaction()
                //.setReorderingAllowed(true) // this allows the postponeEnterTransition to work but affect back transition
                // View and transition name are defined as shared
                .addSharedElement(holderView.artist_name, "${artist.name}")
                .addSharedElement(holderView.artist_pic, "pic_${artist.name}")
                .replace(R.id.fragmentContainerZero, bandDetailFragment)
                .addToBackStack(null)
                .commit()
    }

    companion object {
        val ARG_LIST_NAME = "list_name"

        fun createInstance(listName : String) : ArtistListFragment {
            val args = Bundle()
            args.putString(ARG_LIST_NAME, listName)
            val fragment = ArtistListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}