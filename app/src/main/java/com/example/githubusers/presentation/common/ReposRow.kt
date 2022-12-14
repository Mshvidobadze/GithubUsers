package com.example.githubusers.presentation.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.githubusers.data.remote.responses.ReposResponseItem

@Composable
fun ReposRow(
    rowIndex: Int,
    entries: List<ReposResponseItem>
){
    Column {
        Row {
            RepoEntry(
                entry = entries[rowIndex],
                modifier = Modifier
                    .weight(1f)
            )
        }
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
    }
}