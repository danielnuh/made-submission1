package com.daniel.data

import com.daniel.data.network.response.movie.MovieDetailResponse
import com.daniel.data.network.response.movie.MovieListResponse
import com.daniel.data.network.service.ApiResponse
import com.daniel.data.source.local.MovieLocalDataSource
import com.daniel.data.source.remote.MovieRemoteDataSource
import com.daniel.data.util.DataMapper
import com.daniel.domain.model.movie.MovieDetail
import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.repository.IMovieRepository
import com.daniel.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
): IMovieRepository {
    override fun getMovie(): Flow<Resource<List<MovieList>>> =
        object  : NetworkOnlyResource<List<MovieList>, MovieListResponse>(){
            override fun loadFromNetwork(data: MovieListResponse): Flow<List<MovieList>> =
                DataMapper.mapResponseToDomainMovie(data)

            override suspend fun createCall(): Flow<ApiResponse<MovieListResponse>> =
                remoteDataSource.getMovie()

        }.asFlow()

    override fun getDetail(id:Int): Flow<Resource<MovieDetail>> =
        object : NetworkOnlyResource<MovieDetail, MovieDetailResponse>(){
            override fun loadFromNetwork(data: MovieDetailResponse): Flow<MovieDetail> =
                DataMapper.mapResponseToDomainDetailMovie(data)

            override suspend fun createCall(): Flow<ApiResponse<MovieDetailResponse>> =
                remoteDataSource.getDetail(id)

        }.asFlow()
}