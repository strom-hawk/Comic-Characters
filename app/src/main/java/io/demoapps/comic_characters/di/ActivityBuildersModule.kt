package io.demoapps.comic_characters.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.demoapps.comic_characters.di.auth.AuthModule
import io.demoapps.comic_characters.di.auth.AuthViewModelModule
import io.demoapps.comic_characters.di.main.MainFragmentBuildersModule
import io.demoapps.comic_characters.di.main.MainModule
import io.demoapps.comic_characters.di.main.MainViewModelsModule
import io.demoapps.comic_characters.ui.auth.AuthActivity
import io.demoapps.comic_characters.ui.main.MainActivity

/**
 * This class tell dagger about all the classes that can be injected with dependencies.
 */

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(
        modules = [
            AuthViewModelModule::class
        ]
    )
    abstract fun contributeAuthActivity(): AuthActivity

    @ContributesAndroidInjector(
        modules = [
            MainFragmentBuildersModule::class,
            MainViewModelsModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}
