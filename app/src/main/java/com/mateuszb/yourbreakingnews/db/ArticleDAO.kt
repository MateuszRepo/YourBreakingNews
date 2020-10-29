package com.mateuszb.yourbreakingnews.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mateuszb.yourbreakingnews.models.Article

@Dao
interface ArticleDAO {

    //Function inserts or update article
    // Returns id of inserted/updated article
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateArticle(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}