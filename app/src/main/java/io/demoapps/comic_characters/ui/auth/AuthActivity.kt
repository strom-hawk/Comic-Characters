package io.demoapps.comic_characters.ui.auth

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import io.demoapps.comic_characters.R
import io.demoapps.comic_characters.ui.base.BaseActivity
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
        viewModel.check()
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
}