package com.labs.tekitisoft.genericapp.ui.artistList

import android.view.View
import com.labs.tekitisoft.genericapp.model.entities.LastFMArtist

/**
 * Created by francisco.dominguez on 10/04/18.
 */
interface ArtistListContract{
    interface ArtistListView{
        fun setTopListArtists(artistList : List<LastFMArtist>)

        fun setAdapter(listArtist : List<LastFMArtist>)

        fun itemClicked(holderView: View, artist: LastFMArtist)
    }

    interface ArtistListPresenter{
        fun setView(view : ArtistListFragment)

        fun showTopArtists(page : Int = 1, limit : Int = 30)
    }

}