//package com.interestingarticles.viewmodels
//
//import androidx.lifecycle.ViewModel
//import com.interestingarticles.di.components.ArticleNetworkInjector
//import com.interestingarticles.di.components.DaggerArticleViewModelNetworkInjector
//import com.interestingarticles.di.components.ArticleViewModelNetworkInjector
//import com.interestingarticles.di.modules.NetworkModule
//import com.interestingarticles.repository.ArticleRepo
//
//abstract class BaseViewModel : ViewModel() {
//
//    private val injector: ArticleNetworkInjector = DaggerArticleViewModelNetworkInjector
//        .builder()
//        .networkModule(NetworkModule)
//        .build()
//
//    init {
//        inject()
//    }
//
//    private fun inject() {
//        when (this) {
//            is ArticleRepo -> injector.inject(this)
//        }
//    }
//}