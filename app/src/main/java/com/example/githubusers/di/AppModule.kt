package com.example.githubusers.di

import android.app.Application
import androidx.room.Room
import com.example.githubusers.data.local.data_source.GithubUsersDatabase
import com.example.githubusers.data.local.repository.LocalUsersRepository
import com.example.githubusers.data.local.repository.LocalUsersRepositoryImpl
import com.example.githubusers.data.local.use_cases.AddUsers
import com.example.githubusers.data.local.use_cases.GetUsers
import com.example.githubusers.data.local.use_cases.LocalUsersUseCases
import com.example.githubusers.data.remote.GithubUsersApi
import com.example.githubusers.data.remote.repository.GithubUsersRepository
import com.example.githubusers.data.remote.repository.GithubUsersRepositoryImpl
import com.example.githubusers.data.remote.use_cases.DownloadUsers
import com.example.githubusers.data.remote.use_cases.GetRepos
import com.example.githubusers.data.remote.use_cases.GithubUsersUseCases
import com.example.githubusers.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
        val builder = OkHttpClient()
            .newBuilder()
        builder.addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        return builder
    }

    @Singleton
    @Provides
    fun providesBooksApi(
        okHttpClientBuilder: OkHttpClient.Builder
    ): GithubUsersApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClientBuilder.build())
            .baseUrl(BASE_URL)
            .build()
            .create(GithubUsersApi::class.java)
    }

    @Singleton
    @Provides
    fun provideGithubUsersRepository(api: GithubUsersApi): GithubUsersRepository {
        return GithubUsersRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideGithubUsersUseCases(repository: GithubUsersRepositoryImpl): GithubUsersUseCases {
        return GithubUsersUseCases(
            downloadUsers = DownloadUsers(repository),
            getRepos = GetRepos(repository)
        )
    }

    @Singleton
    @Provides
    fun provideGithubUsersDatabase(app: Application): GithubUsersDatabase {
        return Room.databaseBuilder(
            app,
            GithubUsersDatabase::class.java,
            GithubUsersDatabase.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideLocalUsersRepository(db: GithubUsersDatabase): LocalUsersRepository {
        return LocalUsersRepositoryImpl(db.githubUsersDao)
    }

    @Singleton
    @Provides
    fun provideLocalUsersUseCases(repository: LocalUsersRepository): LocalUsersUseCases {
        return LocalUsersUseCases(
            getUsers = GetUsers(repository),
            addUsers = AddUsers(repository)
        )
    }

}