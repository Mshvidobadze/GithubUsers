package com.example.githubusers

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GithubUsersApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }

}