package com.example.githubusers.presentation.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusers.data.domain.models.UsersResponseItemModel
import com.example.githubusers.data.local.use_cases.LocalUsersUseCases
import com.example.githubusers.data.remote.use_cases.GithubUsersUseCases
import com.example.githubusers.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val githubUsersUseCases: GithubUsersUseCases,
    private val localUsersUseCases: LocalUsersUseCases
) : ViewModel() {

    var error = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    init {
        downloadGithubUsers()
    }

    private fun downloadGithubUsers() {
        viewModelScope.launch {
            isLoading.value = true
            when(val result = githubUsersUseCases.downloadUsers()){
                is Response.Success -> {
                    val userEntries = result.data?.map { user ->
                        UsersResponseItemModel(user.id, user.login, user.avatar_url)
                    }

                    if (userEntries != null) {
                        val response = localUsersUseCases.addUsers.invoke(userEntries)
                        if (response is Response.Success){
                            error.value = ""
                            isLoading.value = false
                        }
                    }
                }
                is Response.Error -> {
                    isLoading.value = false
                    error.value = result.message!!
                }
                else -> {

                }
            }
        }
    }

}