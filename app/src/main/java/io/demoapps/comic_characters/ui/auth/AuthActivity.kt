package io.demoapps.comic_characters.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import io.demoapps.comic_characters.R
import io.demoapps.comic_characters.models.User
import io.demoapps.comic_characters.ui.base.BaseActivity
import io.demoapps.comic_characters.ui.main.MainActivity
import io.demoapps.comic_characters.viewmodel.ViewModelProvidersFactory
import javax.inject.Inject

class AuthActivity : BaseActivity() {
    private val dummyImageUrl = "https://www.superherodb.com/pictures2/portraits/10/100/326.jpg"
    private lateinit var dummyTextView: TextView
    private lateinit var ivLoginLogo: ImageView
    private lateinit var viewModel: AuthViewModel

    @Inject
    lateinit var providerFactory: ViewModelProvidersFactory

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        initVariables()
        initViews()
        setData()
    }

    private fun initVariables() {
        viewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)
        subscribeObserver()
        viewModel.authenticateWithId(10)
    }

    private fun initViews() {
        dummyTextView = findViewById(R.id.dummyTextView)
        ivLoginLogo = findViewById(R.id.ivLoginLogo)
    }

    private fun setData() {
        requestManager
            .load(dummyImageUrl)
            .into(ivLoginLogo)
    }

    private fun subscribeObserver() {
        viewModel.observeAuthState().observe(this, object : Observer<AuthResource<User>> {
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
                            onLoginSuccess()
                            println("--------------hide progressbar, user authenticated")
                        }
                        AuthResource.AuthStatus.NOT_AUTHENTICATED -> {
                            println("--------------hide progressbar, user not authenticated")
                        }
                    }
                }
            }
        })
    }

    private fun onLoginSuccess(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
