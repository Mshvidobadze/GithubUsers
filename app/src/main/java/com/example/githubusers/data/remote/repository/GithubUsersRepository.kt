package com.example.githubusers.data.remote.repository

import com.example.githubusers.data.remote.responses.ReposResponse
import com.example.githubusers.data.remote.responses.UsersResponse
import com.example.githubusers.util.Response

interface GithubUsersRepository {

    suspend fun getUsers(): Response<UsersResponse>

    suspend fun getRepos(login: String): Response<ReposResponse>

}