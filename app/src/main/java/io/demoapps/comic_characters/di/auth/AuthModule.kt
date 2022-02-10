package io.demoapps.comic_characters.di.auth

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.demoapps.comic_characters.di.network.auth.AuthApi
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
object AuthModule {

    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }
}