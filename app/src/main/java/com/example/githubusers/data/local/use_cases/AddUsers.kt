package com.example.githubusers.data.local.use_cases

import com.example.githubusers.data.domain.models.UsersResponseItemModel
import com.example.githubusers.data.local.repository.LocalUsersRepository
import com.example.githubusers.util.Response

class AddUsers(
    private val repository: LocalUsersRepository
) {
    suspend operator fun invoke(users: List<UsersResponseItemModel>): Response<String> {
        return repository.addUsers(users)
    }
}