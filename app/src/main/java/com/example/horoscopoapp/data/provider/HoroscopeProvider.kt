package com.example.horoscopoapp.data.provider

import com.example.horoscopoapp.domain.model.HoroscopeInfo
import com.example.horoscopoapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject


class HoroscopeProvider @Inject constructor() {

    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Escorpio,
            Leo,
            Libra,
            Sagitario,
            Capricornio,
            Piscis,
            Cancer,
            Aquarius,
            Virgo
        )

    }
}