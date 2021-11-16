package com.daniel.domain.model.favorite

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Favorite(
    val id:Int,
    val name:String,
    val overview:String,
    val firstAirDate:String,
    val voteAverage:Float,
    val posterPath:String,
): Parcelable
