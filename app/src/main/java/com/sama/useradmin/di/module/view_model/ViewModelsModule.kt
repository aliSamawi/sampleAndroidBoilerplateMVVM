package com.sama.useradmin.di.module.view_model

import androidx.lifecycle.ViewModel
import com.sama.useradmin.presentation.admin_list.AdminListViewModel
import com.sama.useradmin.presentation.profile.ProfileViewModel
import com.sama.useradmin.presentation.login.LoginViewModel
import com.sama.useradmin.presentation.signup.SignUpViewModel
import com.sama.useradmin.presentation.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindHomeViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    abstract fun bindSignupViewModel(viewModel: SignUpViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AdminListViewModel::class)
    abstract fun bindAdminListViewModel(viewModel: AdminListViewModel): ViewModel

}