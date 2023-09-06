package com.example.horoscopoapp.domain

interface Repository {

    suspend fun getPrediction(sign: String){

    }
}