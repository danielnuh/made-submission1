package com.daniel.data.network.service

import com.daniel.data.BuildConfig
import com.daniel.data.network.response.movie.MovieDetailResponse
import com.daniel.data.network.response.movie.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getMovie(
        @Query("api_key") token: String = BuildConfig.KEY_URL,
        @Query("page") page:Int = 1
    ):MovieListResponse
}