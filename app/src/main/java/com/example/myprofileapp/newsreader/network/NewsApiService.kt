package com.example.myprofileapp.newsreader.network

import com.example.myprofileapp.newsreader.model.Article
import retrofit2.http.GET

interface NewsApiService {
    @GET("posts")
    suspend fun getArticles(): List<Article>
}