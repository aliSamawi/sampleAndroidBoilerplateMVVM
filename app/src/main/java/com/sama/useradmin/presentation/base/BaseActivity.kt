package com.sama.useradmin.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<V : ViewModel> : AppCompatActivity(), HasAndroidInjector {

    abstract val viewModel: V

    abstract fun layoutId(): Int

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    inline fun <reified T : ViewModel> getLazyViewModel(): Lazy<T> =
        lazy {
            ViewModelProvider(this, viewModelFactory)[T::class.java]
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        layoutId().takeIf { it > 0 }?.let { validLayoutId ->
            setContentView(validLayoutId)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}
