package com.interestingarticles.repository

import androidx.lifecycle.LiveData
import com.interestingarticles.database.ArticleDao
import com.interestingarticles.models.Article
import com.interestingarticles.network.Api
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepo @Inject constructor(
    private val articleApi: Api,
    private val articleDao: ArticleDao
) {

    private val MINIMUM_INTERVAL = 6

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