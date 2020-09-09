//package com.interestingarticles.di.modules
//
//import com.interestingarticles.database.AppDatabase
//import com.interestingarticles.database.ArticleDao
//import dagger.Module
//import dagger.Provides
//
//@Module
//object DatabaseModule {
//
//
//    @Provides
//    internal fun provideInterestingArticleDao(appDatabase: AppDatabase): ArticleDao {
//        return appDatabase.articleDao
//    }
//}