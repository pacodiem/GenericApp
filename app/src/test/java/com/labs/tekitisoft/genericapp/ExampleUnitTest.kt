package com.labs.tekitisoft.genericapp

import com.labs.tekitisoft.genericapp.model.entities.LastFMArtist
import com.labs.tekitisoft.genericapp.model.entities.LastFMArtistList
import com.labs.tekitisoft.genericapp.model.services.LastFMService
import com.labs.tekitisoft.genericapp.ui.artistList.ArtistListPresenter
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Mock
    private lateinit var mockArtist: LastFMArtist

    private lateinit var testArtistList: LastFMArtistList

    @Before
    fun setService(){
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(mockArtist.name)
                .thenReturn("Artist test Name")

        testArtistList = LastFMArtistList(listOf(mockArtist))
    }

    @Test
    fun listModel_isCorrect() {
        assertSame("List Model Correct", testArtistList.artists[0].name, "Artist test Name")
    }
}