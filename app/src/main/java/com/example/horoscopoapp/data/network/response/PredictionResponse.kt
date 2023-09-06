package com.example.horoscopoapp.data.network.response

import com.example.horoscopoapp.domain.model.PredictionModel
import com.example.horoscopoapp.domain.model.PredictionNModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse(
    @SerializedName("date") val date: String?,
    @SerializedName("horoscope") val horoscope: String?,
    @SerializedName("sign") val sign: String?
){

}