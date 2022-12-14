package com.example.githubusers.data.local.use_cases

import com.example.githubusers.data.domain.models.UsersResponseItemModel
import com.example.githubusers.data.local.repository.LocalUsersRepository
import kotlinx.coroutines.flow.Flow

class GetUsers(
    private val repository: LocalUsersRepository
) {
    operator fun invoke(): Flow<List<UsersResponseItemModel>> {
        return repository.getUsers()
    }
}