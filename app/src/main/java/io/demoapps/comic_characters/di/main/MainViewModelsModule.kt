package io.demoapps.comic_characters.di.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.demoapps.comic_characters.di.ViewModelKey
import io.demoapps.comic_characters.ui.main.post.PostViewModel
import io.demoapps.comic_characters.ui.main.profile.ProfileViewModel

/**
 * This object returns the view models which has to be mapped for the view model factory.
 */
@Module
abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun bindPostViewModel(postViewModel: PostViewModel): ViewModel
}
