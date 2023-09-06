package com.example.horoscopoapp.domain.model

import com.example.horoscopoapp.R

sealed class HoroscopeInfo(val img: Int, val name: Int){
    //data object, con esto conseguimos la informacion del objeto al usar por ejemplo un log
    data object Aries : HoroscopeInfo(R.drawable.aries, R.string.aries )
    data object  Taurus : HoroscopeInfo(R.drawable.tauro, R.string.taurus,)
    data object Gemini : HoroscopeInfo(R.drawable.geminis, R.string.gemini)
    data object Cancer : HoroscopeInfo(R.drawable.cancer, R.string.cancer)
    data object Leo : HoroscopeInfo(R.drawable.leo, R.string.leo)
    data object Capricornio : HoroscopeInfo(R.drawable.capricornio, R.string.capricornio)
    data object Libra : HoroscopeInfo(R.drawable.libra, R.string.libra)
    data object Sagitario : HoroscopeInfo(R.drawable.sagitario, R.string.sagitario)
    data object Piscis : HoroscopeInfo(R.drawable.piscis, R.string.piscis)
    data object Escorpio : HoroscopeInfo(R.drawable.escorpio, R.string.escorpio)
    object Aquarius : HoroscopeInfo(R.drawable.aquario, R.string.aquarius)
    object Virgo : HoroscopeInfo(R.drawable.virgo, R.string.virgo)
}
