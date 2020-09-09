//package com.interestingarticles.di.components
//
//import com.interestingarticles.di.modules.NetworkModule
//import com.interestingarticles.repository.ArticleRepo
//import com.interestingarticles.viewmodels.ArticleViewModel
//import dagger.Component
//import javax.inject.Singleton
//
//@Singleton
//@Component(modules = [(NetworkModule::class)])
//interface ArticleNetworkInjector {
//
//    fun inject(articleRepo: ArticleRepo)
//
//    @Component.Builder
//    interface Builder {
//        fun build(): ArticleNetworkInjector
//        fun networkModule(networkModule: NetworkModule): Builder
//    }
//}