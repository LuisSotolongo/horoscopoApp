package com.example.horoscopoapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscopoapp.data.provider.HoroscopeProvider
import com.example.horoscopoapp.domain.model.HoroscopeInfo
import com.example.horoscopoapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) : ViewModel() {
    //la variable horoscopeProvider, no es necesaria, pornerle private y val,
    //siempre que accedamos a ella desde el init o otra variable, pero si la queremos usar
    //en otra funcion, si debemos de ponerle private val horoscopeProvider: HoroscopeProvider
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = horoscopeProvider.getHoroscopes()


//        _horoscope.value = listOf(
//            Aries,
//            Taurus,
//            Gemini,
//            Escorpio,
//            Leo,
//            Libra,
//            Sagitario,
//            Capricornio,
//            Piscis,
//            Cancer,
//            Aquarius,

//        )
    }

    fun getHoroscopes() {


    }

}