package com.daniel.domain.model.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieList(
    val id:Int,
    val title:String,
    val overview:String,
    val voteAverage:Float,
    val image:String,
):Parcelable
