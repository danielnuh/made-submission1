package com.daniel.domain.usecase

import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.model.tvshow.TvShowList
import com.daniel.domain.repository.IListRepository
import com.daniel.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ListUseCase {
    fun getMovie(): Flow<Resource<List<MovieList>>>
    fun getTvShow(): Flow<Resource<List<TvShowList>>>
}

class ListInteractor @Inject constructor(
    private val iListRepository: IListRepository
):ListUseCase {
    override fun getMovie(): Flow<Resource<List<MovieList>>> = iListRepository.getMovie()

    override fun getTvShow(): Flow<Resource<List<TvShowList>>> = iListRepository.getTvShow()

}