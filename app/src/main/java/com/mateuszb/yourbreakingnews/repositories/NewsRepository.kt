package com.mateuszb.yourbreakingnews.repositories

import com.mateuszb.yourbreakingnews.api.RetrofitInstance
import com.mateuszb.yourbreakingnews.db.ArticleDatabase
import com.mateuszb.yourbreakingnews.models.Article

class NewsRepository(
    val articleDB: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchForNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun insertOrUpdateArticle(article: Article) = articleDB.getArticleDao()
        .insertOrUpdateArticle(article)

    suspend fun deleteArticle(article: Article) = articleDB.getArticleDao().deleteArticle(article)

    fun getSavedArticles() = articleDB.getArticleDao().getAllArticles()

}