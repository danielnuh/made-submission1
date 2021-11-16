package com.daniel.domain.repository

import com.daniel.domain.model.movie.MovieDetail
import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.model.tvshow.TvShowDetail
import com.daniel.domain.model.tvshow.TvShowList
import com.daniel.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface IDetailRepository {
    fun getMovieDetail(id:Int): Flow<MovieDetail>

    fun getTvShowDetail(id:Int): Flow<TvShowDetail>

    fun isFavoriteMovie(id:Int): Flow<Boolean>

    fun isFavoriteTvShow(id:Int): Flow<Boolean>

    fun setFavoriteMovie(id:Int, isFavorite:Boolean)

    fun setFavoriteTvShow(id:Int, isFavorite:Boolean)

}