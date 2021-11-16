package com.daniel.data.network.response.movie

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class  MovieListResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val results: List<MovieItem>,
    @SerializedName("total_results") val totalResults: Int
){
    @Keep
    data class MovieItem(
        @SerializedName("id") val id: Int,
        @SerializedName("overview") val overview: String,
        @SerializedName("title") val title: String,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("release_date") val releaseDate: String,
        @SerializedName("vote_average") val voteAverage: Float
    )
}
