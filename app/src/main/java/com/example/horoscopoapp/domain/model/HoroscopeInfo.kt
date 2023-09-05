package com.example.horoscopoapp.domain.model

import com.example.horoscopoapp.R
import dagger.hilt.android.AndroidEntryPoint

sealed class HoroscopeInfo(
    val img: Int,
    val name: Int
){
    object Aries : HoroscopeInfo(R.drawable.ic_hand, R.string.aries )
    object  Taurus : HoroscopeInfo(R.drawable.ic_hand, R.string.taurus,)
    object Gemini : HoroscopeInfo(R.drawable.ic_hand, R.string.gemini)
    object Cancer : HoroscopeInfo(R.drawable.ic_hand, R.string.gemini)
    object Leo : HoroscopeInfo(R.drawable.ic_hand, R.string.gemini)
    object Capricornio : HoroscopeInfo(R.drawable.ic_hand, R.string.gemini)
    object Libra : HoroscopeInfo(R.drawable.ic_hand, R.string.gemini)
    object Sagitario : HoroscopeInfo(R.drawable.ic_hand, R.string.gemini)
    object Piscis : HoroscopeInfo(R.drawable.ic_hand, R.string.gemini)
    object Escorpio : HoroscopeInfo(R.drawable.ic_hand, R.string.gemini)
}
