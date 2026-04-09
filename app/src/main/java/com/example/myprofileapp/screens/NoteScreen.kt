package com.example.myprofileapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myprofileapp.navigation.Screen

@Composable
fun NoteScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Daftar Catatan", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate(Screen.NoteDetail.createRoute("123")) }) {
            Text("Lihat Detail Note ID: 123")
        }
        Button(onClick = { navController.navigate("add_note") }) {
            Text("Tambah Catatan Baru")
        }
    }
}

