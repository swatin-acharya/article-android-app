package com.interestingarticles.network

import com.interestingarticles.models.Article
import retrofit2.http.*

interface Api {

    @GET("articles")
    suspend fun getArticles(): List<Article>

    @GET("articles")
    suspend fun getArticleById(@Query("id") id: Int): Article

    @POST("articles")
    suspend fun saveArticle(@Field("article") article: Article)

    @PUT("articles")
    suspend fun updateArticle(@Field("article") article: Article)

}