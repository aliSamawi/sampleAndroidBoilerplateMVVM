package com.sama.useradmin.presentation.signup

import com.sama.useradmin.R
import com.sama.useradmin.presentation.base.BaseActivity

class SignUpActivity : BaseActivity<SignUpViewModel>() {
    override val viewModel: SignUpViewModel by getLazyViewModel()

    override fun layoutId(): Int = R.layout.activity_signup
}