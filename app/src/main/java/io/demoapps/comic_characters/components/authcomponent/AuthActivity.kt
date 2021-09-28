package io.demoapps.comic_characters.components.authcomponent

import android.os.Bundle
import android.widget.TextView
import io.demoapps.comic_characters.R
import io.demoapps.comic_characters.components.basecomponent.BaseActivity

class AuthActivity : BaseActivity() {
    private lateinit var dummyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        initViews()
        setData()
    }

    private fun initViews() {
        dummyTextView = findViewById(R.id.dummyTextView)
    }

    private fun setData() {}
}