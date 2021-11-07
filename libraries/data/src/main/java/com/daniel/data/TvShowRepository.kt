package com.daniel.data

import com.daniel.data.network.response.tvshow.TvShowDetailResponse
import com.daniel.data.network.response.tvshow.TvShowListResponse
import com.daniel.data.network.service.ApiResponse
import com.daniel.data.source.remote.TvShowRemoteDataSource
import com.daniel.data.util.DataMapper
import com.daniel.domain.model.tvshow.TvShowDetail
import com.daniel.domain.model.tvshow.TvShowList
import com.daniel.domain.repository.ITvShowRepository
import com.daniel.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRepository @Inject constructor(
    private val remoteDataSource: TvShowRemoteDataSource
):ITvShowRepository{
    override fun getTvShow(): Flow<Resource<List<TvShowList>>> =
        object : NetworkOnlyResource<List<TvShowList>, TvShowListResponse>(){
            override fun loadFromNetwork(data: TvShowListResponse): Flow<List<TvShowList>> =
                DataMapper.mapResponseToDomainTvShow(data)

            override suspend fun createCall(): Flow<ApiResponse<TvShowListResponse>> =
                remoteDataSource.getTvShow()

        }.asFlow()

    override fun getDetailTvShow(id: Int): Flow<Resource<TvShowDetail>> =
        object :NetworkBoundResource<TvShowDetail, TvShowDetailResponse>(){
            override fun loadFromDB(): Flow<TvShowDetail> {
                TODO("Not yet implemented")
            }

            override fun shouldFetch(data: TvShowDetail?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<TvShowDetailResponse>> =
                remoteDataSource.getDetail(id)

            override suspend fun saveCallResult(data: TvShowDetailResponse) {
                TODO("Not yet implemented")
            }

        }.asFlow()
}