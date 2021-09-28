package io.demoapps.comic_characters.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.demoapps.comic_characters.components.authcomponent.AuthActivity

/**
 * This class tell dagger about all the classes that can be injected with dependencies.
 */

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeAuthActivity(): AuthActivity
}