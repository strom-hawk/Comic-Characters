package io.demoapps.comic_characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import io.demoapps.comic_characters.models.User
import io.demoapps.comic_characters.ui.auth.AuthResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    private val cachedUser = MediatorLiveData<AuthResource<User>>()

    fun authenticateWithId(source: LiveData<AuthResource<User>>) {
        if (cachedUser != null) {
            cachedUser.value = AuthResource.loading(null)
            cachedUser.addSource(source, object : Observer<AuthResource<User>> {
                override fun onChanged(user: AuthResource<User>?) {
                    cachedUser.value = user
                    cachedUser.removeSource(source)
                }
            })
        }
    }

    fun logOut() {
        cachedUser.value = AuthResource.logout()
    }

    fun getAuthUser(): MediatorLiveData<AuthResource<User>> {
        return cachedUser
    }
}