package com.labs.tekitisoft.genericapp.ui.artistDetail

import android.support.v4.app.Fragment
import android.os.Bundle
import android.os.Parcelable
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.labs.tekitisoft.genericapp.R
import com.labs.tekitisoft.genericapp.model.entities.LastFMArtist
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_band_detail.view.*
import kotlinx.android.synthetic.main.item_band.view.*
import java.lang.Exception

/**
 * Created by francisco.dominguez on 05/04/18.
 */
class ArtistDetailFragment : Fragment(){

    private lateinit var rootView : View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // postponeEnterTransition() // This doesn't work unless you call setReorderingAllowed, but that breaks animation on back
        // The best thing is to postpone the call for the new fragment until the image is completely loaded
        return inflater!!.inflate(R.layout.fragment_band_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootView = view.parent.parent as CoordinatorLayout
        rootView.tabLayout.visibility = View.GONE // Hiding the toolbar when attaching this fragment

        // Getting the whole artist object
        val artist = arguments.getParcelable<LastFMArtist>("artist")
        view.artist_det_name.text = artist.name

        Picasso.get()
                .load(artist.images[4].url)
                .fit()
                //.resize(200,200) // Testing resize
                .noFade()
                .into(view.artist_det_pic, object : Callback {
                    override fun onSuccess() {
                        startPostponedEnterTransition()
                    }

                    override fun onError(e: Exception?) {
                        startPostponedEnterTransition()
                    }
                })

        // Transition name of the end fragment defined previously as shared element
        ViewCompat.setTransitionName(view.artist_det_name,  artist.name)
        ViewCompat.setTransitionName(view.artist_det_pic, "pic_${artist.name}")
    }

    override fun onDetach() {
        super.onDetach()
        // Displaying the toolbar on back
        rootView.tabLayout.visibility = View.VISIBLE
    }

    companion object {
        fun newInstance(artist: LastFMArtist) : ArtistDetailFragment {
            val fragment = ArtistDetailFragment()
            val args = Bundle()
            args.putParcelable("artist", artist)
            fragment.arguments = args
            return fragment
        }
    }
}