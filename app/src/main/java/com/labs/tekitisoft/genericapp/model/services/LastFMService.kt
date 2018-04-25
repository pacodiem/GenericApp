package com.labs.tekitisoft.genericapp.model.services

import com.labs.tekitisoft.genericapp.model.entities.LastFMTopArtists
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by francisco.dominguez on 09/04/18.
 */
interface LastFMService{

    @GET("/2.0/?method=chart.gettopartists&api_key=2b693bb30cf57ac27cb86e6b92f62546&format=json")
    fun getTopArtists(@Query("page") page: Int = 1, @Query("limit") limit: Int = 30): Single<LastFMTopArtists>

    companion object {
        fun create(): LastFMService{

            val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }

            val client : OkHttpClient = OkHttpClient.Builder().apply {
                this.addInterceptor(interceptor)
            }.build()

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://ws.audioscrobbler.com")
                    .client(client)
                    .build()

            return retrofit.create(LastFMService::class.java)
        }
    }

}