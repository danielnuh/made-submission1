package com.daniel.data.source.remote

import android.util.Log
import com.daniel.data.network.response.movie.MovieListResponse
import com.daniel.data.network.response.tvshow.TvShowDetailResponse
import com.daniel.data.network.response.tvshow.TvShowListResponse
import com.daniel.data.network.service.ApiResponse
import com.daniel.data.network.service.TvShowService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRemoteDataSource @Inject constructor(private val tvShowService: TvShowService){

    fun getTvShow():Flow<ApiResponse<TvShowListResponse>>{
        return flow {
            try {
                val response = tvShowService.getTvShow()
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