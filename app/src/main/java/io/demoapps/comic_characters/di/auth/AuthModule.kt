package io.demoapps.comic_characters.di.auth

import dagger.Module
import dagger.Provides
import io.demoapps.comic_characters.network.auth.AuthApi
import retrofit2.Retrofit

@Module
object AuthModule {

    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }
}