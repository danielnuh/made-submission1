package com.daniel.domain.usecase

import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.model.tvshow.TvShowList
import com.daniel.domain.repository.IFavoriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface FavoriteUseCase {
    fun getMovie(): Flow<List<MovieList>>
    fun getTvShow(): Flow<List<TvShowList>>
}

class FavoriteInteractor @Inject constructor(
    private val iFavoriteRepository: IFavoriteRepository
):FavoriteUseCase {
    override fun getMovie(): Flow<List<MovieList>> = iFavoriteRepository.getMovie()

    override fun getTvShow(): Flow<List<TvShowList>> =  iFavoriteRepository.getTvShow()
}