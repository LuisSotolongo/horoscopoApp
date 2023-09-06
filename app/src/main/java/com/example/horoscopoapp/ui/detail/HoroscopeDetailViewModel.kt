package com.example.horoscopoapp.ui.detail

import androidx.lifecycle.ViewModel
import com.example.horoscopoapp.domain.usecase.GetPredictionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase): ViewModel() {

    private val _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    fun example(){
       // getPredictionUseCase()
    }

}