package com.sama.useradmin.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.sama.useradmin.R
import com.sama.useradmin.presentation.base.BaseActivity
import com.sama.useradmin.presentation.profile.ProfileActivity
import com.sama.useradmin.presentation.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginViewModel>() {
    override val viewModel: LoginViewModel by getLazyViewModel()

    override fun layoutId(): Int = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpViews()
        setUpViewModels()
    }

    private fun setUpViews(){
        title = getString(R.string.login)

        btnLogin.setOnClickListener {
            hideKeyboard()
            viewModel.loginUser(
                inputEmail.text.toString(),
                inputPassword.text.toString())
        }

        btnSignup.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
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

        viewModel.loginSuccess.observe(this, Observer {
            startActivity(Intent(this,ProfileActivity::class.java).putExtra(
                ProfileActivity.USER,it
            ))
            finish()
        })

    }
}