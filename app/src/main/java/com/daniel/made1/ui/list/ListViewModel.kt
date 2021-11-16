package com.daniel.made1.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daniel.domain.usecase.ListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    listUseCase: ListUseCase
):ViewModel(){
    val movie = listUseCase.getMovie().asLiveData()
    val tvShow = listUseCase.getTvShow().asLiveData()
}