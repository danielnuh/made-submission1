package com.daniel.data.network.response.tvshow

import androidx.annotation.Keep
import com.daniel.data.network.response.movie.MovieListResponse
import com.google.gson.annotations.SerializedName

data class TvShowListResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val results: List<TvShowItem>,
    @SerializedName("total_results") val totalResults: Int
){
    @Keep
    data class TvShowItem(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("overview") val overview: String,
        @SerializedName("first_air_date") val firstAirDate: String,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("vote_average") val voteAverage: Float,
        )
}