package io.demoapps.comic_characters.ui.auth

import androidx.lifecycle.*
import io.demoapps.comic_characters.models.User
import io.demoapps.comic_characters.network.auth.AuthApi
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AuthViewModel
@Inject constructor(
    private val authApi: AuthApi
) : ViewModel() {
    private val authUser = MediatorLiveData<AuthResource<User>>()

    fun authenticateWithId(userId: Int) {
        authUser.value = AuthResource.loading(null)
        val source: LiveData<AuthResource<User>> = LiveDataReactiveStreams.fromPublisher(
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

        authUser.addSource(source, object : Observer<AuthResource<User>> {
            override fun onChanged(user: AuthResource<User>?) {
                authUser.value = user
                authUser.removeSource(source)
            }
        })
    }

    fun observeAuthUser(): LiveData<AuthResource<User>> {
        return authUser
    }
}