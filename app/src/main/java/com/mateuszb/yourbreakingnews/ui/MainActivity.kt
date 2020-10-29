package com.mateuszb.yourbreakingnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.mateuszb.yourbreakingnews.R
import com.mateuszb.yourbreakingnews.db.ArticleDatabase
import com.mateuszb.yourbreakingnews.repositories.NewsRepository
import com.mateuszb.yourbreakingnews.viewmodels.NewsViewModel
import com.mateuszb.yourbreakingnews.viewmodels.NewsViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var newsViwModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val newsModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        newsViwModel = ViewModelProvider(this, newsModelProviderFactory).get(NewsViewModel::class.java)
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}