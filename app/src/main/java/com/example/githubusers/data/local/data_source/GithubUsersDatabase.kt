package com.example.githubusers.data.local.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubusers.data.domain.models.UsersResponseItemModel

@Database(
    entities = [UsersResponseItemModel::class],
    version = 1
)
abstract class GithubUsersDatabase: RoomDatabase() {

    abstract val githubUsersDao: GithubUsersDao

    companion object{
        const val DATABASE_NAME = "github_users_db"
    }
}