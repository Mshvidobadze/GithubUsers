package com.example.githubusers.presentation.main.user_details_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusers.data.remote.responses.ReposResponseItem
import com.example.githubusers.data.remote.use_cases.GithubUsersUseCases
import com.example.githubusers.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val githubUsersUseCases: GithubUsersUseCases
) : ViewModel() {

    var reposList = mutableStateOf<List<ReposResponseItem>>(listOf())
    var error = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun getRepos(login: String){
        viewModelScope.launch {
            isLoading.value = true

            val result = githubUsersUseCases.getRepos(login)
            when(result){
                is Response.Success -> {
                    val repoEntries = result.data?.map { repo ->
                        ReposResponseItem(
                            repo.name,
                            repo.updated_at,
                            repo.stargazers_count,
                            repo.language,
                            repo.html_url
                        )
                    }
                    error.value = ""
                    isLoading.value = false
                    if (repoEntries != null) {
                        reposList.value = repoEntries
                    }

                }
            }
        }
    }

}