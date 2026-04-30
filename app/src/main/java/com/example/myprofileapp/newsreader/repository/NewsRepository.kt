package com.example.myprofileapp.newsreader.repository

import com.example.myprofileapp.newsreader.model.Article
import com.example.myprofileapp.newsreader.network.RetrofitClient

class NewsRepository {
    private val api = RetrofitClient.instance

    suspend fun getArticles(): Result<List<Article>> {
        return try {
            Result.success(api.getArticles())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}