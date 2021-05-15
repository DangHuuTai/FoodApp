package com.example.foodapp.Movie.rest

import com.example.foodapp.Movie.MovieResp
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieDBService {
    @GET("movie/now_playing")
    suspend fun listNowPlayingMovie(
        @Query("language")language : String,
        @Query("page")page : Int,
        @Query("api_key")apiKey : String
    ) : MovieResp
}