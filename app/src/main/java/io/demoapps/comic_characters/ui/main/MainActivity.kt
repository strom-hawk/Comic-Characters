package io.demoapps.comic_characters.ui.main

import android.os.Bundle
import io.demoapps.comic_characters.R
import io.demoapps.comic_characters.ui.base.BaseActivity

class MainActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
