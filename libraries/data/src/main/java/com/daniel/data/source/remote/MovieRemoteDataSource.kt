package com.daniel.data.source.remote

import android.util.Log
import com.daniel.data.network.response.movie.MovieListResponse
import com.daniel.data.network.service.ApiResponse
import com.daniel.data.network.service.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRemoteDataSource @Inject constructor(private val movieService: MovieService) {

    fun getMovie():Flow<ApiResponse<MovieListResponse>>{
        return flow {
            try {
                val response = movieService.getMovie()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}