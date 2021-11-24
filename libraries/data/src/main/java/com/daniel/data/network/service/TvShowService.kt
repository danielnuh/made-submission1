package com.daniel.data.network.service

import com.daniel.data.BuildConfig
import com.daniel.data.network.response.tvshow.TvShowDetailResponse
import com.daniel.data.network.response.tvshow.TvShowListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowService {
    @GET("tv/popular")
    suspend fun getTvShow(
        @Query("api_key")token:String = BuildConfig.KEY_URL,
        @Query("page")page:Int = 2
    ):TvShowListResponse
}