package com.example.githubusers.data.remote.repository

import com.example.githubusers.data.remote.GithubUsersApi
import com.example.githubusers.data.remote.responses.ReposResponse
import com.example.githubusers.data.remote.responses.UsersResponse
import com.example.githubusers.util.Response
import javax.inject.Inject

class GithubUsersRepositoryImpl @Inject constructor(
    private val api: GithubUsersApi
): GithubUsersRepository {

    override suspend fun getUsers(): Response<UsersResponse> {
        val response = try {
            api.getUsers()
        } catch (e: Exception) {
            return Response.Error("Error occurred")
        }
        return Response.Success(response)
    }

    override suspend fun getRepos(login: String): Response<ReposResponse> {
        val response = try {
            api.getRepos(login)
        } catch (e: Exception) {
            return Response.Error("Error occurred")
        }
        return Response.Success(response)
    }

}