package com.sama.useradmin.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.sama.useradmin.R
import com.sama.useradmin.data.model.USER_ROLE
import com.sama.useradmin.presentation.base.BaseActivity
import com.sama.useradmin.presentation.login.LoginActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity<ProfileViewModel>() {

    companion object{
        val USER = "USER"
    }

    override val viewModel: ProfileViewModel by getLazyViewModel()

    override fun layoutId(): Int = R.layout.activity_profile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
        setUpViewModel()
    }

    private fun setupViews(){
        title = "profile"

        val user = viewModel.getCurrentUser()
        inputEmail.setText(user?.email)
        inputPassword.setText( user?.password)

        if (user?.role == USER_ROLE.REGULAR){
            tvFullname.text = user.fullname
            llTopHolder.visibility = View.VISIBLE
            btnUpdate.visibility = View.VISIBLE
            btnDelete.visibility = View.VISIBLE
            inputEmail.isFocusable = true
            inputPassword.isFocusable = true
        } else {
            llTopHolder.visibility = View.GONE
            btnUpdate.visibility = View.GONE
            btnDelete.visibility = View.GONE
            inputEmail.isFocusable = false
            inputPassword.isFocusable = false
        }

        btnUpdate.setOnClickListener {
            viewModel.updateCurrentUser(
                inputEmail.text.toString(),inputPassword.text.toString())
        }

        btnDelete.setOnClickListener {
            viewModel.removeCurrentUser()
            startActivity(Intent(this,LoginActivity::class.java))
            finishAffinity()
        }

        btnLogout.setOnClickListener {
            viewModel.logoutUser()
            startActivity(Intent(this,LoginActivity::class.java))
            finishAffinity()
        }
    }

    private fun setUpViewModel(){
        viewModel.validationError.observe(this, Observer {error ->
            Snackbar
                .make(
                    mainLayout,
                    error,
                    Snackbar.LENGTH_LONG
                ).show()
        })

        viewModel.updateSuccess.observe(this, Observer {
            Snackbar
                .make(
                    mainLayout,
                    "profile updated.",
                    Snackbar.LENGTH_LONG
                ).show()
        })

    }
}
