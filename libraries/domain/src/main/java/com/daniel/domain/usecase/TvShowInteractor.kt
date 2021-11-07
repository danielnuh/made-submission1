package com.daniel.domain.usecase

import com.daniel.domain.model.tvshow.TvShowDetail
import com.daniel.domain.model.tvshow.TvShowList
import com.daniel.domain.repository.ITvShowRepository
import com.daniel.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface TvShowUseCase {
    fun getTvShow(): Flow<Resource<List<TvShowList>>>
    fun getDetail(id:Int): Flow<Resource<TvShowDetail>>
}

class TvShowInteractor @Inject constructor(private val iTvShowRepository: ITvShowRepository):TvShowUseCase{
    override fun getTvShow() = iTvShowRepository.getTvShow()

    override fun getDetail(id:Int) = iTvShowRepository.getDetailTvShow(id)
}