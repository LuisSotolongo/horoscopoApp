package com.example.horoscopoapp.domain.model

import com.example.horoscopoapp.R

sealed class HoroscopeInfo(val img: Int, val name: Int){
    object Aries : HoroscopeInfo(R.drawable.aries, R.string.aries )
    object  Taurus : HoroscopeInfo(R.drawable.tauro, R.string.taurus,)
    object Gemini : HoroscopeInfo(R.drawable.geminis, R.string.gemini)
    object Cancer : HoroscopeInfo(R.drawable.cancer, R.string.cancer)
    object Leo : HoroscopeInfo(R.drawable.geminis, R.string.leo)
    object Capricornio : HoroscopeInfo(R.drawable.capricornio, R.string.capricornio)
    object Libra : HoroscopeInfo(R.drawable.libra, R.string.libra)
    object Sagitario : HoroscopeInfo(R.drawable.sagitario, R.string.sagitario)
    object Piscis : HoroscopeInfo(R.drawable.piscis, R.string.piscis)
    object Escorpio : HoroscopeInfo(R.drawable.escorpio, R.string.escorpio)
}
