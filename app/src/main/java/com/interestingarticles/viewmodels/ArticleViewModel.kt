package com.interestingarticles.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interestingarticles.models.Article
import com.interestingarticles.repository.ArticleRepo
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ArticleViewModel @ViewModelInject constructor(private val articleRepo: ArticleRepo) :
    ViewModel() {

    private val _spinner = MutableLiveData<Boolean>()
    val spinner: LiveData<Boolean> = _spinner
    private val _snackBar = MutableLiveData<String?>()
    val snackBar: LiveData<String?> = _snackBar

    val articleList: LiveData<List<Article>> = articleRepo.getAllArticles()

    val currentArticle = MutableLiveData<Article>()

    fun clearSnackBar() {
        _snackBar.value = null
    }

    init {
        loadArticles()
    }

    private fun prepareForRepoCall(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                block()
                _spinner.value = true
            } catch (error: Throwable) {
                _snackBar.value = error.message
            } finally {
                _spinner.value = false
            }
        }
    }

    private fun loadArticles() {
        prepareForRepoCall {
            articleRepo.getNetworkArticles()
        }
    }

}