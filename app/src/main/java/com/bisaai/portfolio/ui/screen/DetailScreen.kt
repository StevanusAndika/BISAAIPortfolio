package com.bisaai.portfolio.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bisaai.portfolio.viewmodel.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    postId: Int,
    navController: NavController,
    viewModel: AppViewModel
) {
    LaunchedEffect(postId) {
        // Fetch data if needed
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Post Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Post Info Card
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "API Data Example",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Post ID: $postId")
                    Text("Title: Sample Post Title")
                    Text("Content: This is sample content from the API.")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // API Info
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "API Information",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text("Source: JSONPlaceholder")
                    Text("Endpoint: /posts/$postId")
                    Text("Status: Connected")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // BISA AI Info
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "BISA AI - Portfolio Project",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text("Mobile App with API Integration")
                    Text("UI/UX: Material Design 3")
                    Text("API: JSONPlaceholder")
                }
            }
        }
    }
}