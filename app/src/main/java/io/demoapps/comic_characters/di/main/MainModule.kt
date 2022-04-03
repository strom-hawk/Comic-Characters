package io.demoapps.comic_characters.di.main

import dagger.Module
import dagger.Provides
import io.demoapps.comic_characters.network.main.MainApi
import retrofit2.Retrofit

@Module
class MainModule {
    companion object {

        @Provides
        fun provideMainApi(retrofit: Retrofit): MainApi {
            return retrofit.create(MainApi::class.java)
        }
    }
}