package com.example.horoscopoapp.data

import android.util.Log
import com.example.horoscopoapp.data.network.HoroscopeApiService

import com.example.horoscopoapp.domain.Repository
import com.example.horoscopoapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(private val apiService: HoroscopeApiService): Repository {

    override suspend fun getPrediction(sign:String): PredictionModel?{
        //llamar a retrofit
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("TAG", "ha ocurrido un error ${it.message}") }
        return null
    }
}