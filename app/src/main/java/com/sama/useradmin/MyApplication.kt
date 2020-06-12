package com.sama.useradmin

import android.app.Application
import com.sama.useradmin.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        setupComponent()
    }

    private fun setupComponent() {
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }
}
