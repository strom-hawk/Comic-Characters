package io.demoapps.comic_characters.ui.main.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.demoapps.comic_characters.SessionManager
import io.demoapps.comic_characters.models.User
import io.demoapps.comic_characters.ui.auth.AuthResource
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val sessionManager: SessionManager
): ViewModel() {

    fun getAuthenticatedUser(): LiveData<AuthResource<User>> {
        return sessionManager.getAuthUser()
    }
}
