package com.interestingarticles.di.modules

import android.app.Application
import androidx.room.Room
import com.interestingarticles.database.AppDatabase
import com.interestingarticles.database.ArticleDao
import com.interestingarticles.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabaseInstance(@ApplicationContext context: Application): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    internal fun provideInterestingArticleDao(appDatabase: AppDatabase): ArticleDao {
        return appDatabase.articleDao
    }
}