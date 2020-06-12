package com.sama.useradmin.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.sama.useradmin.R
import com.sama.useradmin.presentation.base.BaseActivity
import com.sama.useradmin.presentation.profile.ProfileActivity
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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        btnSignup.setOnClickListener {
            hideKeyboard()
            viewModel.signUpUser(input_fullName.text.toString(),
                inputEmail.text.toString(),
                inputPassword.text.toString(),
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
            startActivity(Intent(this,ProfileActivity::class.java).putExtra(
                ProfileActivity.USER,it
            ))
            finishAffinity()
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}