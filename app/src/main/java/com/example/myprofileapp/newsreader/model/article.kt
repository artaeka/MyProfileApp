package com.example.myprofileapp.newsreader.model

data class Article(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
) {
    // Karena JSONPlaceholder tidak punya image, kita generate dari id
    val imageUrl: String
        get() = "https://picsum.photos/seed/$id/400/200"

    val description: String
        get() = body.take(100) + "..."
}