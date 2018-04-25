package com.labs.tekitisoft.genericapp.ui.artistList

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.labs.tekitisoft.genericapp.R
import com.labs.tekitisoft.genericapp.model.entities.LastFMArtist
import kotlinx.android.synthetic.main.item_band.view.*

/**
 * Created by francisco.dominguez on 05/04/18.
 * @param listName name of the list
 * @param artistList list of artist objects
 * @param clickListener clickListener is also received as parameter, thanks to kotlin it's not necessary to implement OnClickListener
 */
class ArtistListAdapter(var listName: String, var artistList: List<LastFMArtist>, private val clickListener: (View, LastFMArtist) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_band, parent, false)
        return ArtistViewHolder.newInstance(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = viewHolder as ArtistViewHolder

        // This transition name must be unique, can be the same defined as shared element but it's not mandatory
        ViewCompat.setTransitionName(holder.view.artist_name, "fif_${listName}_${artistList[position].name}")
        ViewCompat.setTransitionName(holder.view.artist_pic, "pic_${listName}_${artistList[position].name}")

        holder.setTextAndImage(artistList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}