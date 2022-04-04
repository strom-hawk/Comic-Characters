package io.demoapps.comic_characters.di.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.demoapps.comic_characters.ui.main.post.PostFragment
import io.demoapps.comic_characters.ui.main.profile.ProfileFragment

/**
 * This object returns the fragments which has to be included in the main activity component.
 */
@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostFragment
}
