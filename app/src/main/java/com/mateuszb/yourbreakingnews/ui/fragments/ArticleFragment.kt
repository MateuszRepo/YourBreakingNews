package com.mateuszb.yourbreakingnews.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.mateuszb.yourbreakingnews.R
import com.mateuszb.yourbreakingnews.ui.MainActivity
import com.mateuszb.yourbreakingnews.viewmodels.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var newsViewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel = (activity as MainActivity).newsViwModel
        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        fab.setOnClickListener{
            newsViewModel.saveArticle(article)
            Snackbar.make(view,"Article saved", Snackbar.LENGTH_SHORT).show()
        }
    }

}