package io.demoapps.comic_characters.di.auth

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.demoapps.comic_characters.di.ViewModelKey
import io.demoapps.comic_characters.ui.auth.AuthViewModel

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    internal abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel
}