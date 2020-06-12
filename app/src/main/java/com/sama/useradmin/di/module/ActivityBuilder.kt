package com.sama.useradmin.di.module

import com.sama.useradmin.presentation.profile.ProfileActivity
import com.sama.useradmin.presentation.login.LoginActivity
import com.sama.useradmin.presentation.signup.SignUpActivity
import com.sama.useradmin.presentation.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): ProfileActivity

    @ContributesAndroidInjector
    abstract fun contributeSignupActivity(): SignUpActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity
}