package com.daniel.domain.repository

import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.model.tvshow.TvShowList
import com.daniel.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface IListRepository {
    fun getMovie(): Flow<Resource<List<MovieList>>>

    fun getTvShow(): Flow<Resource<List<TvShowList>>>
}