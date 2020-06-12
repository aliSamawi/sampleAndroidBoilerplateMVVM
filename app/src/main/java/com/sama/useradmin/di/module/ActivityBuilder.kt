package com.sama.useradmin.di.module

import com.sama.useradmin.presentation.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): HomeActivity
}