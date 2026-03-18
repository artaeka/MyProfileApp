package com.example.myprofileapp.ui1

import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import com.example.myprofileapp.viewmodel.ProfileViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(viewModel: ProfileViewModel = viewModel()) {

    val uiState by viewModel.uiState.collectAsState()

    var name by remember { mutableStateOf(uiState.name) }
    var bio by remember { mutableStateOf(uiState.bio) }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Profile")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        OutlinedTextField(
            value = bio,
            onValueChange = { bio = it },
            label = { Text("Bio") }
        )

        Button(onClick = {
            viewModel.updateName(name)
            viewModel.updateBio(bio)
        }) {
            Text("Save")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Dark Mode")
            Switch(
                checked = uiState.isDarkMode,
                onCheckedChange = { viewModel.toggleDarkMode() }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Preview:")
        Text("Name: ${uiState.name}")
        Text("Bio: ${uiState.bio}")
    }
}