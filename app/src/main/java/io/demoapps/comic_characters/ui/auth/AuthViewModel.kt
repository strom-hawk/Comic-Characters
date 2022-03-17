package io.demoapps.comic_characters.ui.auth

import androidx.lifecycle.*
import io.demoapps.comic_characters.SessionManager
import io.demoapps.comic_characters.models.User
import io.demoapps.comic_characters.network.auth.AuthApi
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AuthViewModel @Inject constructor(
    private val authApi: AuthApi,
    private val sessionManager: SessionManager
) : ViewModel() {


    fun authenticateWithId(userId: Int) {
        sessionManager.authenticateWithId(queryUserId(userId))
    }

    private fun queryUserId(userId: Int): LiveData<AuthResource<User>> {
        return LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userId = userId.toString())
                .onErrorReturn(object : Function<Throwable, User> {
                    override fun apply(t: Throwable?): User {
                        return User(userId = -1, "", "", "")
                    }
                })
                .map(object : Function<User, AuthResource<User>> {
                    override fun apply(user: User): AuthResource<User> {
                        if (user.userId == -1) {
                            return AuthResource.error("-------Could not authenticate", null)
                        }
                        return AuthResource.authenticated(user)
                    }
                })
                .subscribeOn(Schedulers.io())
        )
    }

    fun observeAuthState(): LiveData<AuthResource<User>> {
        return sessionManager.getAuthUser()
    }
}