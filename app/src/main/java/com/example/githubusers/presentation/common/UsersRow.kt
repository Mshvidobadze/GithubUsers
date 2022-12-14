package com.example.githubusers.presentation.common

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.githubusers.data.domain.models.UsersResponseItemModel

@Composable
fun UsersRow(
    rowIndex: Int,
    entries: List<UsersResponseItemModel>,
    navController: NavController
){
    Column {
        Row {
            UserEntry(
                entry = entries[rowIndex * 2],
                navController = navController,
                modifier = Modifier
                    .weight(1f)
            )
            Spacer(
                modifier = Modifier
                    .width(15.dp)
            )
            if(entries.size >= rowIndex * 2 + 2){
                UserEntry(
                    entry = entries[rowIndex * 2 + 1],
                    navController = navController,
                    modifier = Modifier
                        .weight(1f)
                )
            } else {
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
    }
}