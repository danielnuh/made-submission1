package com.daniel.data.network.response.tvshow

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class TvShowDetailResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("firstAirDate") val firstAirDate: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("original_name") val originalName: String
)
