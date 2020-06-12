package com.sama.useradmin.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.sama.useradmin.R
import com.sama.useradmin.presentation.base.BaseActivity
import com.sama.useradmin.presentation.home.HomeActivity
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : BaseActivity<SignUpViewModel>() {
    override val viewModel: SignUpViewModel by getLazyViewModel()

    override fun layoutId(): Int = R.layout.activity_signup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpViews()
        setUpViewModels()
    }

    private fun setUpViews(){
        title = getString(R.string.signup)

        btnSignup.setOnClickListener {
            viewModel.signUpUser(input_fullName.text.toString(),
                input_email_username.text.toString(),
                input_password.text.toString(),
                input_confirm_password.text.toString())
        }
    }

    private fun setUpViewModels(){
        viewModel.validationError.observe(this, Observer {error ->
            Snackbar
                .make(
                    mainLayout,
                    error,
                    Snackbar.LENGTH_LONG
                ).show()
        })

        viewModel.signupSuccess.observe(this, Observer {
            startActivity(Intent(this,HomeActivity::class.java).putExtra(
                HomeActivity.USER,it
            ))
            finish()
        })

    }
}