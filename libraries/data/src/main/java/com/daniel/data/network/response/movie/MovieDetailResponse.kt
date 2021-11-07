package com.daniel.data.network.response.movie

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MovieDetailResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("release_date") val release_date: String
)