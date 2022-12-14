package com.example.githubusers.data.local.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubusers.data.domain.models.UsersResponseItemModel
import kotlinx.coroutines.flow.Flow

@Dao
interface GithubUsersDao {

    @Query("SELECT * FROM usersresponseitemmodel")
    fun getUsers(): Flow<List<UsersResponseItemModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUsers(users: List<UsersResponseItemModel>)

}