package com.thesis.vovatraining.common.api.data

import com.google.gson.GsonBuilder
import com.thesis.vovatraining.model.genres.GenresModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("genre/movie/list")
    fun getGenres(@Query("api_key") api_key : String, @Query("language") language : String) : Observable<GenresModel>

    companion object{
        fun createApi() : Api{
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            return retrofit.create(Api::class.java)
        }
    }
}