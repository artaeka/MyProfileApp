package com.example.myprofileapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myprofileapp.data.ProfileUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUIState())
    val uiState: StateFlow<ProfileUIState> = _uiState

    fun updateName(newName: String) {
        _uiState.update { it.copy(name = newName) }
    }

    fun updateBio(newBio: String) {
        _uiState.update { it.copy(bio = newBio) }
    }

    fun toggleDarkMode() {
        _uiState.update { it.copy(isDarkMode = !it.isDarkMode) }
    }
}