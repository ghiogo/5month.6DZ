package com.example.a5month6dz.di

import com.example.a5month6dz.data.remote.RetrofitClient
import com.example.a5month6dz.data.remote.apiservice.TopHeadlinesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideNewsApiService(): TopHeadlinesApiService {
        return retrofitClient.provideTopHeadlinesApiService()
    }
}