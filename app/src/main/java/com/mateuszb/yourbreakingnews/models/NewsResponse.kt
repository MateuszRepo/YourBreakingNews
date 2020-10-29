package com.mateuszb.yourbreakingnews.models

import com.mateuszb.yourbreakingnews.models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)