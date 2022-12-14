package com.example.githubusers.data.remote.responses

data class ReposResponseItem(
    val name: String?,
    val updated_at: String?,
    val stargazers_count: Int?,
    val language: String?,
    val html_url: String?
)