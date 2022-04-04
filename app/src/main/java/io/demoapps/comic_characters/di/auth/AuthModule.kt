package io.demoapps.comic_characters.di.auth

import dagger.Module
import dagger.Provides
import io.demoapps.comic_characters.network.auth.AuthApi
import retrofit2.Retrofit

/**
 * This is an auth module class that provides Auth api for the activity or fragment.
 * This object will be provided to the activity in whose module it will be added
 * in the activity builders module.
 */
@Module
class AuthModule {

    companion object{
        @Provides
        fun provideAuthApi(retrofit: Retrofit): AuthApi {
            return retrofit.create(AuthApi::class.java)
        }
    }
}