package io.demoapps.comic_characters.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.demoapps.comic_characters.ui.auth.AuthViewModel
import io.demoapps.comic_characters.ui.main.profile.ProfileViewModel
import io.demoapps.comic_characters.viewmodel.ViewModelProvidersFactory

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelProvidersFactory): ViewModelProvider.Factory
}
