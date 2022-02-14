package io.demoapps.comic_characters.ui.auth

import androidx.lifecycle.ViewModel
import io.demoapps.comic_characters.models.User
import io.demoapps.comic_characters.network.auth.AuthApi
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel
@Inject constructor(
    private val authApi: AuthApi
) : ViewModel() {
    /*@Inject
    lateinit var authApi: AuthApi*/

    fun check() {
        authApi.getUser("1")
            .toObservable()
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<User> {
                override fun onSubscribe(d: Disposable?) {}

                override fun onNext(value: User) {
                    println("---------: ${value.userEmail}")
                }

                override fun onError(e: Throwable) {
                    println("---------: ${e}")
                }

                override fun onComplete() {}
            })
    }
}