package io.demoapps.comic_characters.ui.main.post

import androidx.lifecycle.ViewModel
import io.demoapps.comic_characters.SessionManager
import io.demoapps.comic_characters.network.main.MainApi
import javax.inject.Inject

class PostViewModel
@Inject constructor(
    val sessionManager: SessionManager,
    val mainApi: MainApi
) : ViewModel() {

    fun checkPostViewModel(){
        println("-------post view model working")
    }
}