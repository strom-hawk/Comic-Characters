package io.demoapps.comic_characters.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.demoapps.comic_characters.BaseApplication
import io.demoapps.comic_characters.di.auth.AuthModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        AuthModule::class,
        AppModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}