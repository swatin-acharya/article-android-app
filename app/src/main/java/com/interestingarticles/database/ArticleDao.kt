package com.interestingarticles.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.interestingarticles.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: Article)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<Article>)

    @Query("select * from Article")
    fun getArticles(): LiveData<List<Article>>

    @Query("select * from Article where id= :id")
    fun getArticleById(id: Int): LiveData<Article>

    @Update
    suspend fun updateArticle(article: Article)

    @Delete
    suspend fun deleteArticle(article: Article)

}