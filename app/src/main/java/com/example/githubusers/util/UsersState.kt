package com.example.githubusers.util

import com.example.githubusers.data.domain.models.UsersResponseItemModel

data class UsersState(
    val users: List<UsersResponseItemModel> = emptyList()
)
