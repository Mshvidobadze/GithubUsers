package com.example.githubusers.data.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UsersResponseItemModel(
    @PrimaryKey val id: Int,
    val login: String,
    val avatar_url: String
)
