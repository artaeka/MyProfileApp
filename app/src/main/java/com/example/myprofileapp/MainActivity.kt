package com.example.myprofileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.myprofileapp.newsreader.model.Article
import com.example.myprofileapp.newsreader.ui.NewsDetailScreen
import com.example.myprofileapp.newsreader.ui.NewsListScreen
import com.example.myprofileapp.ui.theme.MyProfileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyProfileAppTheme {
                var selectedArticle by remember { mutableStateOf<Article?>(null) }

                if (selectedArticle == null) {
                    NewsListScreen(
                        onArticleClick = { article ->
                            selectedArticle = article
                        }
                    )
                } else {
                    NewsDetailScreen(
                        article = selectedArticle!!,
                        onBack = { selectedArticle = null }
                    )
                }
            }
        }
    }
}