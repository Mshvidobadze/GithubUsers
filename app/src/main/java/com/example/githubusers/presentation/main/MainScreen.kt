package com.example.githubusers.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.githubusers.presentation.main.user_details_screen.UserDetailsScreen
import com.example.githubusers.presentation.main.users_list_screen.UsersListScreen

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
) {

    val error by remember { viewModel.error }
    val isLoading by remember { viewModel.isLoading }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if(isLoading || error.isNotEmpty()) {
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        } else {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "users_list_screen"
            ){
                composable(
                    "users_list_screen"
                ){
                    UsersListScreen(navController = navController)
                }
                composable(
                    "user_details_screen/{login}",
                    arguments = listOf(
                        navArgument("login"){
                            type = NavType.StringType
                        }
                    )
                ){
                    val login = remember {
                        it.arguments?.getString("login")
                    }
                    if (login != null) {
                        UserDetailsScreen(login = login, navController = navController)
                    }
                }
            }
        }
    }

}