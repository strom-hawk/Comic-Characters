package io.demoapps.comic_characters.ui.base

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import io.demoapps.comic_characters.SessionManager
import io.demoapps.comic_characters.models.User
import io.demoapps.comic_characters.ui.auth.AuthActivity
import io.demoapps.comic_characters.ui.auth.AuthResource
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity(){
    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeObserver()
    }

    private fun subscribeObserver(){
        sessionManager.getAuthUser().observe(this, object : Observer<AuthResource<User>> {
            override fun onChanged(userAuthResource: AuthResource<User>?) {
                if (userAuthResource != null) {
                    when (userAuthResource.status) {
                        AuthResource.AuthStatus.LOADING -> {
                            println("--------------show progressbar")
                        }
                        AuthResource.AuthStatus.ERROR -> {
                            println("--------------hide progressbar, error")
                        }
                        AuthResource.AuthStatus.AUTHENTICATED -> {
                            println("--------------hide progressbar, user authenticated")
                        }
                        AuthResource.AuthStatus.NOT_AUTHENTICATED -> {
                            navigateToLoginScreen()
                            println("--------------hide progressbar, user not authenticated")
                        }
                    }
                }
            }
        })
    }

    private fun navigateToLoginScreen(){
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }
}
