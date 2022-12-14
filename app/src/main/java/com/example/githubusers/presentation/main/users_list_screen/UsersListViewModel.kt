package com.example.githubusers.presentation.main.users_list_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusers.data.local.use_cases.LocalUsersUseCases
import com.example.githubusers.util.UsersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(
    private val localUsersUseCases: LocalUsersUseCases
) : ViewModel() {

    private val _state = mutableStateOf(UsersState())
    val state: State<UsersState> = _state

    init {
        getUsers()
    }

    fun getUsers() {
        localUsersUseCases.getUsers()
            .onEach { users ->
                _state.value = state.value.copy(
                    users = users
                )
            }
            .launchIn(viewModelScope)
    }

}