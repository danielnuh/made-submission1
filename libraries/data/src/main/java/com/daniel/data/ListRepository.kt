package com.daniel.data

import com.daniel.data.network.response.movie.MovieListResponse
import com.daniel.data.network.response.tvshow.TvShowListResponse
import com.daniel.data.network.service.ApiResponse
import com.daniel.data.source.local.MovieLocalDataSource
import com.daniel.data.source.local.TvShowLocalDataSource
import com.daniel.data.source.remote.MovieRemoteDataSource
import com.daniel.data.source.remote.TvShowRemoteDataSource
import com.daniel.data.util.DataMapper
import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.model.tvshow.TvShowList
import com.daniel.domain.repository.IListRepository
import com.daniel.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListRepository @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource
):IListRepository{
    override fun getMovie(): Flow<Resource<List<MovieList>>> =
        object : NetworkBoundResource<List<MovieList>, MovieListResponse>() {
            override fun loadFromDB(): Flow<List<MovieList>> =
                movieLocalDataSource.getAll().map {
                    DataMapper.mapResponseToDomainMovie(it)
                }

            override fun shouldFetch(data: List<MovieList>?): Boolean = data == null || data.isEmpty()

            override fun createCall(): Flow<ApiResponse<MovieListResponse>> =
                movieRemoteDataSource.getMovie()

            override suspend fun saveCallResult(data: MovieListResponse) {
                val movieList = DataMapper.mapResponseToEntityMovie(data)
                movieLocalDataSource.insert(movieList)
            }

        }.asFlow()

    override fun getTvShow(): Flow<Resource<List<TvShowList>>> =
        object : NetworkBoundResource<List<TvShowList>, TvShowListResponse>() {
            override fun loadFromDB(): Flow<List<TvShowList>> =
                tvShowLocalDataSource.getAll().map {
                    DataMapper.mapResponseToDomainTvShow(it)
                }

            override fun shouldFetch(data: List<TvShowList>?): Boolean = data == null || data.isEmpty()

            override fun createCall(): Flow<ApiResponse<TvShowListResponse>> =
                tvShowRemoteDataSource.getTvShow()

            override suspend fun saveCallResult(data: TvShowListResponse) {
                val tvShowList = DataMapper.mapResponseToEntityTvShow(data)
                tvShowLocalDataSource.insert(tvShowList)
            }

        }.asFlow()
}