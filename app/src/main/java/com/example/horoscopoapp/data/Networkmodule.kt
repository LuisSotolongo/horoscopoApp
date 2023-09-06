package com.example.horoscopoapp.data

import com.example.horoscopoapp.data.network.HoroscopeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object Networkmodule {

    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://newastro.vercel.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit):HoroscopeApiService{
        return retrofit.create(HoroscopeApiService::class.java)
    }
}