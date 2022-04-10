package io.demoapps.comic_characters.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * This is a custom view model factory.
 * We need a custom view model factory for the following reasons:
 * 1. If the view model has more than one parameter to be initialized.
 * 2. We need to make our view model aware of the life cycle of an activity or fragment.
 */

class ViewModelProvidersFactory
@Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        viewModels[modelClass]?.get() as T
}
