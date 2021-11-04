package io.demoapps.comic_characters.ui.auth

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AuthViewModel
@Inject constructor() : ViewModel(){
    fun check(){
        println("-------viewmodel working")
    }
}