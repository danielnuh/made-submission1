package com.daniel.domain.model.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetail(
    val id:Int,
    val title:String,
    val overview:String,
    val posterPath:String,
    val voteAverage:Float,
    val isFavorite:Boolean,
):Parcelable