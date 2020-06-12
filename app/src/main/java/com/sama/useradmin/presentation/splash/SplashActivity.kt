package com.sama.useradmin.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.sama.useradmin.R
import com.sama.useradmin.presentation.base.BaseActivity
import com.sama.useradmin.presentation.home.HomeActivity


class SplashActivity : BaseActivity<SplashViewModel>(){

    override val viewModel: SplashViewModel by getLazyViewModel()

    override fun layoutId(): Int =
        R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.splashLiveData.observe(this, Observer {
            when (it) {
                is SplashState.HomeActivity -> {
                    finish()
                    startActivity(Intent(this, HomeActivity::class.java))
                }
            }
        })
    }
}