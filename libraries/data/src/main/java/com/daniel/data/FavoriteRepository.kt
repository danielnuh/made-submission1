package com.daniel.data

import com.daniel.data.source.local.MovieLocalDataSource
import com.daniel.data.source.local.TvShowLocalDataSource
import com.daniel.data.util.DataMapper
import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.model.tvshow.TvShowList
import com.daniel.domain.repository.IFavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteRepository @Inject constructor(
    private val movieLocalDataSource: MovieLocalDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource
) : IFavoriteRepository {
    override fun getMovie(): Flow<List<MovieList>> {
        return movieLocalDataSource.getFavorite().map {
            DataMapper.mapResponseToDomainMovie(it)
        }
    }

    override fun getTvShow(): Flow<List<TvShowList>>{
        return tvShowLocalDataSource.getFavorite().map {
            DataMapper.mapResponseToDomainTvShow(it)
        }
    }
}