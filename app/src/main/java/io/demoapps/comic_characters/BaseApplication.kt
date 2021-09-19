package io.demoapps.comic_characters

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.demoapps.comic_characters.di.DaggerAppComponent

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}