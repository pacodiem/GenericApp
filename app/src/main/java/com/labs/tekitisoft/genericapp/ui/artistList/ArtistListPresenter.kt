package com.labs.tekitisoft.genericapp.ui.artistList

import android.util.Log
import com.labs.tekitisoft.genericapp.model.repositories.LastFMRepository
import com.labs.tekitisoft.genericapp.model.services.LastFMService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by francisco.dominguez on 09/04/18.
 */
class ArtistListPresenter @Inject constructor(private val bandRepository : LastFMRepository) : ArtistListContract.ArtistListPresenter{

    private lateinit var view : ArtistListFragment
    //private var bandService : LastFMService = LastFMService.create()
    //private var bandRepository = LastFMRepository(bandService)

    override fun setView(view : ArtistListFragment){
        this.view = view
    }

    override fun showTopArtists(page : Int, limit : Int) {
         bandRepository.getTopArtists(page, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->

                            view.setAdapter(result.topArtists.artists)
                            view.setTopListArtists(result.topArtists.artists)
                            /*result.bands.map {
                                Log.d("STACKOVERFLOW USERS", "${it.name}, ${it.playcount}")
                                //userRepository.getDetails(it.userId)
                            }*/
                        },
                        { error ->
                            //TODO view.displayError(error.message)
                        }
                )
    }
}