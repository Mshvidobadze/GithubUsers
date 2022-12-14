package com.example.githubusers.data.local.repository

import com.example.githubusers.data.domain.models.UsersResponseItemModel
import com.example.githubusers.util.Response
import kotlinx.coroutines.flow.Flow

interface LocalUsersRepository {

    fun getUsers(): Flow<List<UsersResponseItemModel>>

    suspend fun addUsers(users: List<UsersResponseItemModel>): Response<String>

}