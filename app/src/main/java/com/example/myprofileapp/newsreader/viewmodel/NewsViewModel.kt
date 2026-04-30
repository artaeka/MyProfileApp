package com.example.myprofileapp.newsreader.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myprofileapp.newsreader.model.Article
import com.example.myprofileapp.newsreader.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class UiState {
    object Loading : UiState()
    data class Success(val articles: List<Article>) : UiState()
    data class Error(val message: String) : UiState()
}

class NewsViewModel : ViewModel() {
    private val repository = NewsRepository()

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init { fetchArticles() }

    fun fetchArticles() {
        _uiState.value = UiState.Loading
        viewModelScope.launch {
            repository.getArticles().fold(
                onSuccess = { _uiState.value = UiState.Success(it) },
                onFailure = { _uiState.value = UiState.Error(it.message ?: "Error") }
            )
        }
    }
}