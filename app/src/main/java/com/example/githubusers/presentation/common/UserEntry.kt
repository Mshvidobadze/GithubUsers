package com.example.githubusers.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.githubusers.data.domain.models.UsersResponseItemModel

@Composable
fun UserEntry(
    entry: UsersResponseItemModel,
    navController: NavController,
    modifier: Modifier = Modifier
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(Color.White)
            .clickable {
                navController.navigate(
                    "user_details_screen/${entry.login}"
                )
            }
    ){
        Column{
            Image(
                painter = rememberImagePainter(data = entry.avatar_url),
                contentDescription = entry.login,
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = entry.login,
                color = Color.Black,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}