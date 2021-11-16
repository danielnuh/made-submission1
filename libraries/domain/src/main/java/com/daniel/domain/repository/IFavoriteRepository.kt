package com.daniel.domain.repository

import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.model.tvshow.TvShowList
import com.daniel.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface IFavoriteRepository {
    fun getMovie(): Flow<List<MovieList>>

    fun getTvShow(): Flow<List<TvShowList>>
}