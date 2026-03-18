package com.example.myprofileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myprofileapp.ui.theme.MyProfileAppTheme
import com.example.myprofileapp.ui1.ProfileScreen
import com.example.myprofileapp.viewmodel.ProfileViewModel
import androidx.compose.runtime.getValue
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: ProfileViewModel = viewModel()
            val uiState by viewModel.uiState.collectAsState()

            MyProfileAppTheme(darkTheme = uiState.isDarkMode) {
                ProfileScreen(viewModel)
            }
        }
    }
}

@Composable
fun MyProfileApp() {
    Surface(modifier = Modifier.fillMaxSize()) {
        ProfileCard()
    }
}
@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileHeader()

            Spacer(modifier = Modifier.height(16.dp))

            InfoItem("Email", "arta@email.com")
            InfoItem("Phone", "+62 8123456789")
            InfoItem("Location", "Lampung, Indonesia")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {}) {
                Text("Follow")
            }
        }
    }
}
@Composable
fun ProfileHeader() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Photo",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Arta Eka",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "UI/UX Designer & Frontend Learner",
            fontSize = 14.sp
        )
    }
}
@Composable
fun InfoItem(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = label, fontWeight = FontWeight.SemiBold)
        Text(text = value)
    }
}