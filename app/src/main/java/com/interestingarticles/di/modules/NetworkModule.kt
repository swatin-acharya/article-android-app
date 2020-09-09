//package com.interestingarticles.di.modules
//
//import com.interestingarticles.network.Api
//import com.interestingarticles.utils.BASE_URL
//import dagger.Module
//import dagger.Provides
//import dagger.Reusable
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//@Module
//object NetworkModule
//{
//    @Provides
//    @Reusable
//    internal fun provideInterestingArticleApi(retrofit: Retrofit): Api
//    {
//        return retrofit.create(Api::class.java)
//    }
//
//    @Provides
//    @Reusable
//    internal fun provideRetrofitInterface():Retrofit
//    {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//}