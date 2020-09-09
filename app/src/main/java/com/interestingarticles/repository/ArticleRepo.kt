package com.interestingarticles.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.interestingarticles.database.AppDatabase
import com.interestingarticles.models.Article
import com.interestingarticles.network.AppNetwork

class ArticleRepo(application: Application) {

    private val MINIMUM_INTERVAL = 6

    private var articleDao = AppDatabase.getInstance(application).articleDao
    private var articleApi = AppNetwork.getInstance()

    fun getAllArticles(): LiveData<List<Article>> {
        return articleDao.getArticles()
    }

    suspend fun getNetworkArticles() {
        articleDao.insertArticles(articleApi.getArticles())
    }

    suspend fun getNetworkArticleById(id: Int): Article {
        return articleApi.getArticleById(id)
    }

    suspend fun updateNetworkArticle(article: Article) {
        articleApi.updateArticle(article)
    }

    suspend fun saveNetworkArticle(article: Article) {
        articleApi.saveArticle(article)
    }

//    private fun isFetchNeeded(savedAt: Date): Boolean {
//        val diffInMillisec: Long = Calendar.getInstance().timeInMillis - savedAt.time
//        val hours = TimeUnit.MILLISECONDS.toHours(diffInMillisec)
//        return hours > MINIMUM_INTERVAL
//    }

}