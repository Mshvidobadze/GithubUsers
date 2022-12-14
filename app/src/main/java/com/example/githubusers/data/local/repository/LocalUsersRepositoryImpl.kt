package com.example.githubusers.data.local.repository

import com.example.githubusers.data.domain.models.UsersResponseItemModel
import com.example.githubusers.data.local.data_source.GithubUsersDao
import com.example.githubusers.util.Response
import kotlinx.coroutines.flow.Flow

class LocalUsersRepositoryImpl (
    private val dao: GithubUsersDao
): LocalUsersRepository {

    override fun getUsers(): Flow<List<UsersResponseItemModel>> {
        return dao.getUsers()
    }

    override suspend fun addUsers(users: List<UsersResponseItemModel>): Response<String> {
        try {
            dao.addUsers(users)
        } catch (e: Exception) {
            return Response.Error("Error occurred")
        }
        return Response.Success("SUCCESS")
    }

}