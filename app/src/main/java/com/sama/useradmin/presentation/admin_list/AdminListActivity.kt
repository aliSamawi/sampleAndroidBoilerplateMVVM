package com.sama.useradmin.presentation.admin_list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sama.useradmin.R
import com.sama.useradmin.data.model.User
import com.sama.useradmin.presentation.base.BaseActivity
import com.sama.useradmin.presentation.profile.ProfileActivity
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
        title = "Regular Users"

        userAdapter = UserAdapter(mutableListOf(), object : UserAdapter.UserRvAdapterCallback {
            override fun onRemoveClicked(user: User) {
                viewModel.removeUser(user.email)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.admin_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        return if (id == R.id.profile) {
            startActivity(Intent(this, ProfileActivity::class.java))
            true
        } else super.onOptionsItemSelected(item)
    }
}