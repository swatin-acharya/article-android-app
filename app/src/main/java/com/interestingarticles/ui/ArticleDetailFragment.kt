package com.interestingarticles.ui

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.interestingarticles.databinding.FragmentArticleDetailBinding
import com.interestingarticles.repository.ArticleRepo
import com.interestingarticles.viewmodels.ArticleViewModel

class ArticleDetailFragment : Fragment() {

    private lateinit var articleRepo: ArticleRepo
    private lateinit var binding: FragmentArticleDetailBinding
    private lateinit var articleViewModel: ArticleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleDetailBinding.inflate(inflater, container, false)
        context ?: return binding.root
        articleRepo = ArticleRepo(activity?.applicationContext as Application)
        articleViewModel = ViewModelProviders.of(
            activity as MainActivity,
            ArticleViewModel.FACTORY(articleRepo)
        ).get(ArticleViewModel::class.java)
        articleViewModel.currentArticle.observe(activity as MainActivity) {
            article -> binding.article = article
        }
        return binding.root
    }
}