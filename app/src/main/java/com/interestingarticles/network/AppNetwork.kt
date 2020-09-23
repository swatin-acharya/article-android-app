package com.interestingarticles.network

import com.interestingarticles.utils.BASE_URL
import com.interestingarticles.utils.SECUREKEY
import com.interestingarticles.utils.SECUREVAL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class AppNetwork {

    companion object {

        fun getInstance(): Retrofit {

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header(SECUREKEY, SECUREVAL)
                val request = requestBuilder.build()
                chain.proceed(request)
            }


            httpClient.connectTimeout(30, TimeUnit.SECONDS)
            httpClient.readTimeout(30, TimeUnit.SECONDS)

            httpClient.addNetworkInterceptor(logging)

            val okHttpClient = httpClient.build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
    }
}