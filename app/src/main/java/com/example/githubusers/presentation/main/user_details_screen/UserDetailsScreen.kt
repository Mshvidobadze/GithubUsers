package com.example.githubusers.presentation.main.user_details_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.githubusers.presentation.common.ReposRow

@Composable
fun UserDetailsScreen(
    login: String,
    navController: NavController,
    viewModel: UserDetailsViewModel = hiltViewModel()
) {

    viewModel.getRepos(login)

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp)
    ) {
        Column {
            ReposList(navController = navController)
        }
    }

}

@Composable
fun ReposList(
    navController: NavController,
    viewModel: UserDetailsViewModel = hiltViewModel()
){

    val reposList by remember { viewModel.reposList }
    val isLoading by remember { viewModel.isLoading }
    val error by remember { viewModel.error }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if(isLoading || error.isNotEmpty()) {
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        } else {
            LazyColumn(contentPadding = PaddingValues(15.dp)){
                if(reposList.isNotEmpty()){
                    val itemCount = reposList.size

                    items(itemCount){
                        ReposRow(
                            rowIndex = it,
                            entries = reposList
                        )
                    }
                }
            }
        }
    }

}