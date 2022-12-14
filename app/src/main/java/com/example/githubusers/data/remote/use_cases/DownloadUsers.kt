package com.example.githubusers.data.remote.use_cases

import com.example.githubusers.data.remote.repository.GithubUsersRepository
import com.example.githubusers.data.remote.responses.UsersResponse
import com.example.githubusers.util.Response

class DownloadUsers(
    private val repository: GithubUsersRepository
) {
    suspend operator fun invoke(): Response<UsersResponse> {
        return repository.getUsers()
    }
}