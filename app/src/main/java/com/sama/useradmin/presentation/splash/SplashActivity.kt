package com.sama.useradmin.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.sama.useradmin.R
import com.sama.useradmin.presentation.base.BaseActivity
import com.sama.useradmin.presentation.profile.ProfileActivity
import com.sama.useradmin.presentation.login.LoginActivity


class SplashActivity : BaseActivity<SplashViewModel>(){

    override val viewModel: SplashViewModel by getLazyViewModel()

    override fun layoutId(): Int =
        R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.splashLiveData.observe(this, Observer {
            when (it) {
                is SplashState.Login ->{
                    finish()
                    startActivity(Intent(this, LoginActivity::class.java))
                }
                is SplashState.Admin ->{
                    finish()
                    startActivity(Intent(this, ProfileActivity::class.java))
                }
                is SplashState.Regular -> {
                    finish()
                    startActivity(Intent(this, ProfileActivity::class.java))
                }
            }
        })
    }
}