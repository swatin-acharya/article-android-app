package com.interestingarticles.di

import com.interestingarticles.network.Api
import com.interestingarticles.network.AppNetwork
import com.interestingarticles.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    internal fun provideRetrofitInstance(): Retrofit {
        return AppNetwork.getInstance()
    }

    @Provides
    @Singleton
    internal fun provideInterestingArticleApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}