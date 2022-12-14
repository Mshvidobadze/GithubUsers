package com.example.githubusers.data.remote

import com.example.githubusers.data.remote.responses.ReposResponse
import com.example.githubusers.data.remote.responses.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubUsersApi {

    @GET("users")
    suspend fun getUsers(): UsersResponse

    @GET("users/{login}/repos")
    suspend fun getRepos(
        @Path("login") login: String
    ): ReposResponse

}