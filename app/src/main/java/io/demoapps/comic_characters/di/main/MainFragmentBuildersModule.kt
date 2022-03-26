package io.demoapps.comic_characters.di.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.demoapps.comic_characters.ui.main.profile.ProfileFragment

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment
}
