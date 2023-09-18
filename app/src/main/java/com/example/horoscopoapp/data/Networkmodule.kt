package com.example.horoscopoapp.data

import com.example.horoscopoapp.BuildConfig.BASE_URL
import com.example.horoscopoapp.core.interceptors.AuthInterceptor
import com.example.horoscopoapp.data.network.HoroscopeApiService
import com.example.horoscopoapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Networkmodule {

    @Provides
    @Singleton
    fun providesRetrofit(OkHttpClient: OkHttpClient):Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient{
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit):HoroscopeApiService{
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun providesRepository(apiService: HoroscopeApiService): Repository{
        return RepositoryImplementation(apiService)
    }
}