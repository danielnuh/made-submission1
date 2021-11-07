package com.daniel.made1.ui.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daniel.domain.usecase.TvShowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(tvShowUseCase: TvShowUseCase) : ViewModel() {
    val tvShow = tvShowUseCase.getTvShow().asLiveData()
}