package com.example.myprofileapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun NoteDetailScreen(noteId: String?, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Detail Catatan", style = MaterialTheme.typography.headlineMedium)
        Text(text = "ID yang diterima: $noteId")
        Button(onClick = { navController.popBackStack() }) {
            Text("Kembali")
        }
    }
}