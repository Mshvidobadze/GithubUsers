package com.example.githubusers.data.remote.use_cases

import com.example.githubusers.data.remote.repository.GithubUsersRepository
import com.example.githubusers.data.remote.responses.ReposResponse
import com.example.githubusers.util.Response

class GetRepos(
    private val repository: GithubUsersRepository
) {
    suspend operator fun invoke(login: String): Response<ReposResponse> {
        return repository.getRepos(login)
    }
}