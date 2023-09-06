package com.example.horoscopoapp.domain.usecase

import com.example.horoscopoapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository){
    //operator permite sobrescribir algunas funciones
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)

}