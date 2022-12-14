package com.example.githubusers.presentation.main.users_list_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.githubusers.presentation.common.UsersRow

@Composable
fun UsersListScreen(
    navController: NavController
) {

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp)
    ) {
        Column {
            UsersList(navController = navController)
        }
    }

}

@Composable
fun UsersList(
    navController: NavController,
    viewModel: UsersListViewModel = hiltViewModel()
){

    val usersList by remember { viewModel.state }

    LazyColumn(contentPadding = PaddingValues(15.dp)){
        if(usersList.users.isNotEmpty()){
            val itemCount = if(usersList.users.size % 2 == 0){
                usersList.users.size / 2
            } else{
                usersList.users.size / 2 + 1
            }

            items(itemCount){
                UsersRow(
                    rowIndex = it,
                    entries = usersList.users,
                    navController = navController
                )
            }
        }
    }

}