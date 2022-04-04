package io.demoapps.comic_characters.di.main

import dagger.Module
import dagger.Provides
import io.demoapps.comic_characters.network.main.MainApi
import retrofit2.Retrofit

/**
 * This is an main module class that provides main api for the activity or fragment.
 * This object will be provided to the activity in whose module it will be added
 * in the activity builders module.
 */
@Module
class MainModule {
    companion object {

        @Provides
        fun provideMainApi(retrofit: Retrofit): MainApi {
            return retrofit.create(MainApi::class.java)
        }
    }
}