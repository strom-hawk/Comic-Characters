package io.demoapps.comic_characters.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.demoapps.comic_characters.ui.auth.AuthViewModel
import io.demoapps.comic_characters.viewmodel.ViewModelProvidersFactory

/*
@Module
class ViewModelFactoryModule {
    */
/*@Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProvidersFactory?): ViewModelProvider.Factory?*//*


    companion object {
        @Provides
        fun bindViewModelFactory(factory: ViewModelProvidersFactory): ViewModelProvider.Factory {
            return factory
        }
    }

}*/

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProvidersFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun authViewModel(viewModel: AuthViewModel): ViewModel
}