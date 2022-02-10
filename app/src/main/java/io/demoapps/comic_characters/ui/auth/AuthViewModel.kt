package io.demoapps.comic_characters.ui.auth

import androidx.lifecycle.ViewModel
import io.demoapps.comic_characters.di.auth.AuthModule
import io.demoapps.comic_characters.di.network.auth.AuthApi
import javax.inject.Inject

class AuthViewModel
@Inject constructor(
    private val authApi: AuthApi
) : ViewModel() {
    /*@Inject
    lateinit var authApi: AuthApi*/

    fun check() {
        authApi.getFakeStuff()
        println("-------viewmodel working")
        if(authApi == null){
            println("-----------auth api is null")
        }else{
            println("-----------auth api is not null")
        }
    }
}