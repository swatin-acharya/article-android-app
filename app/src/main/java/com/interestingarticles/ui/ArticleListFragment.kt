package com.interestingarticles.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.interestingarticles.R
import com.interestingarticles.databinding.FragmentArticleListBinding
import com.interestingarticles.models.Article
import com.interestingarticles.viewmodels.ArticleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleListFragment : Fragment(), ArticleAdapter.OnItemClickListener {

    private lateinit var binding: FragmentArticleListBinding
    private val articleViewModel: ArticleViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.articleList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.articleList.setHasFixedSize(true)
        binding.articleList.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )

        articleViewModel.spinner.observe(viewLifecycleOwner) { show ->
            binding.spinner.visibility = if (show) View.VISIBLE else View.GONE
        }
        articleViewModel.snackBar.observe(viewLifecycleOwner) { text ->
            text?.let {
                makeSnackBar(binding.root, text)
            }
        }
        val adapter = ArticleAdapter(this)
        binding.articleList.adapter = adapter
        articleViewModel.articleList.observe(viewLifecycleOwner) { articles ->
            adapter.submitList(articles)
        }

        return binding.root
    }

    private fun makeSnackBar(rootView: View, message: String) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show()
        articleViewModel.clearSnackBar()
    }

    override fun onItemClick(article: Article) {
        articleViewModel.currentArticle.value = article
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_articleListFragment_to_articleDetailFragment)
    }

}