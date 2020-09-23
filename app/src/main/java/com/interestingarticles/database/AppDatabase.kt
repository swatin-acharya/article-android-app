package com.interestingarticles.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.interestingarticles.models.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val articleDao: ArticleDao
}