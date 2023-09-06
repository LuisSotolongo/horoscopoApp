package com.example.horoscopoapp.data

import android.util.Log
import com.example.horoscopoapp.data.network.HoroscopeApiService
import com.example.horoscopoapp.domain.Repository
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(private val apiService: HoroscopeApiService): Repository {

    override suspend fun getPrediction(sign:String){
        //llamar a retrofit
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess {  }
            .onFailure { Log.i("TAG", "ha ocurrido un error ${it.message}") }
    }
}