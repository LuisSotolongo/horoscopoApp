package com.example.horoscopoapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscopoapp.domain.model.HoroscopeModel
import com.example.horoscopoapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.loading)
    val state: StateFlow<HoroscopeDetailState> = _state
    lateinit var horoscope: HoroscopeModel
    fun getHoroscope(sign: HoroscopeModel) {
        horoscope = sign
        viewModelScope.launch {
            _state.value = HoroscopeDetailState.loading
            val result = withContext(Dispatchers.IO) {getPredictionUseCase(sign.name)}//hilo secundario
           if (result!=null){
               _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
           }else{
               _state.value = HoroscopeDetailState.Error("Ha ocurrido un error")
           }
        }
        //hilo principal
    }

}