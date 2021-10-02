package io.demoapps.comic_characters.components.authcomponent

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.RequestManager
import io.demoapps.comic_characters.R
import io.demoapps.comic_characters.components.basecomponent.BaseActivity
import javax.inject.Inject

class AuthActivity : BaseActivity() {
    private val dummyImageUrl = "https://www.superherodb.com/pictures2/portraits/10/100/326.jpg"
    private lateinit var dummyTextView: TextView
    private lateinit var ivLoginLogo: ImageView

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        initViews()
        setData()
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