package io.demoapps.comic_characters.ui.auth

import androidx.lifecycle.*
import io.demoapps.comic_characters.models.User
import io.demoapps.comic_characters.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel
@Inject constructor(
    private val authApi: AuthApi
) : ViewModel() {
    private val authUser = MediatorLiveData<User>()

    fun authenticateWithId(userId: Int) {
        val source: LiveData<User> = LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userId = userId.toString())
                .subscribeOn(Schedulers.io())
        )

        authUser.addSource(source, object : Observer<User> {
            override fun onChanged(user: User?) {
                authUser.value = user
                authUser.removeSource(source)
            }
        })
    }

    fun observeAuthUser(): LiveData<User> {
        return authUser
    }
}