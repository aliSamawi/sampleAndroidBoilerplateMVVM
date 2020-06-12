package com.sama.useradmin.di.module.view_model

import androidx.lifecycle.ViewModel
import com.sama.useradmin.presentation.home.HomeViewModel
import com.sama.useradmin.presentation.signup.SignUpViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    abstract fun bindSignupViewModel(viewModel: SignUpViewModel): ViewModel
}