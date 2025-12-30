package com.bisaai.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bisaai.portfolio.ui.screens.DashboardScreen
import com.bisaai.portfolio.ui.screens.DetailScreen
import com.bisaai.portfolio.ui.screens.ProfileScreen
import com.bisaai.portfolio.ui.theme.BISAAIPortfolioTheme  // INI YANG DIUBAH
import com.bisaai.portfolio.viewmodel.AppViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BISAAIPortfolioTheme {  // GANTI DENGAN NAMA YANG SAMA DENGAN Theme.kt
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = AppViewModel()
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "dashboard"
                    ) {
                        composable("dashboard") {
                            DashboardScreen(
                                navController = navController,
                                viewModel = viewModel
                            )
                        }

                        composable(
                            route = "detail/{postId}",
                            arguments = listOf(
                                navArgument("postId") {
                                    type = NavType.IntType
                                }
                            )
                        ) { backStackEntry ->
                            val postId = backStackEntry.arguments?.getInt("postId")
                            DetailScreen(
                                navController = navController,
                                postId = postId ?: 1,
                                viewModel = viewModel
                            )
                        }

                        composable("profile") {
                            ProfileScreen(
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}