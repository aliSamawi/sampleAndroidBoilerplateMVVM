package com.sama.useradmin.presentation.admin_list

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sama.useradmin.R
import com.sama.useradmin.data.model.User
import com.sama.useradmin.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_admin_list.*

class AdminListActivity : BaseActivity<AdminListViewModel>() {

    lateinit var userAdapter: UserAdapter

    override val viewModel: AdminListViewModel by getLazyViewModel()

    override fun layoutId(): Int = R.layout.activity_admin_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViews()
        setupViewModel()
    }

    private fun setupViews(){
        userAdapter = UserAdapter(mutableListOf(), object : UserAdapter.UserRvAdapterCallback {
            override fun onRemoveClicked(user: User) {
                //remove user
            }

        })
        rvUsers.apply {
            layoutManager = LinearLayoutManager(this@AdminListActivity)
            adapter = userAdapter
        }
    }

    private fun setupViewModel(){
        viewModel.getRegularUsers().observe(this, Observer {
            userAdapter.updateItems(it)
        })
    }
}