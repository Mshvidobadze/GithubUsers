package com.example.githubusers.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.githubusers.data.remote.responses.ReposResponseItem

@Composable
fun RepoEntry(
    entry: ReposResponseItem,
    modifier: Modifier = Modifier
){
    val uriHandler = LocalUriHandler.current
    Box(
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .clickable {
                if (entry.html_url != null) {
                    uriHandler.openUri(entry.html_url!!)
                }
            }
    ){
        Column{
            Text(
                text = entry.name?: "Default",
                color = Color.Black,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp)
            )
            Text(
                text = entry.updated_at?: "",
                color = Color.Black,
                fontSize = 15.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp)
            )
            Text(
                text = entry.stargazers_count.toString(),
                color = Color.Black,
                fontSize = 15.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp)
            )
            Text(
                text = entry.language?: "",
                color = Color.Black,
                fontSize = 15.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp)
            )
        }
    }
}