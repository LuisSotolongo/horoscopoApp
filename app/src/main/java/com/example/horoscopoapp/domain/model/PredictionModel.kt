package com.example.horoscopoapp.domain.model

data class PredictionModel(
    val horoscope: String,
    val sign: String
){

    fun toDomain(): PredictionModel {
       return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )

    }
}