package com.example.horoscopoapp.data.network

import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sing") sign:String){

    }
}