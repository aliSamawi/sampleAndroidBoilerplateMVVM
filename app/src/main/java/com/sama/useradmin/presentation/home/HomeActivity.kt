package com.sama.useradmin.presentation.home

import android.os.Bundle
import androidx.lifecycle.Observer
import com.sama.useradmin.R
import com.sama.useradmin.presentation.base.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel>() {

    companion object{
        val USER = "USER"
    }

    override val viewModel: HomeViewModel by getLazyViewModel()

    override fun layoutId(): Int = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getRegularUsers()
        viewModel.getAllUsers().observe(this, Observer {users ->

        })
    }
}
