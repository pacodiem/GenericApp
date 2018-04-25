package com.labs.tekitisoft.genericapp.ui.artistList

import android.support.v7.widget.RecyclerView
import android.view.View
import com.labs.tekitisoft.genericapp.model.entities.LastFMArtist
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_band.view.*

/**
 * Created by francisco.dominguez on 05/04/18.
 */
class ArtistViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun newInstance(parent: View): ArtistViewHolder {
            return ArtistViewHolder(parent)
        }
    }

    fun setTextAndImage(artist : LastFMArtist, clickListener : (View, LastFMArtist) -> Unit) {
        Picasso.get().load(artist.images[2].url).into(view.artist_pic)
        view.artist_name.text = artist.name

        // Setting listener to artist_name view
        view.artist_name.setOnClickListener({clickListener(view, artist)})
    }
}