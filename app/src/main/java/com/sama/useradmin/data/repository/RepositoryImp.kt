package com.sama.useradmin.data.repository

import androidx.lifecycle.LiveData
import com.sama.useradmin.data.model.USER_ROLE
import com.sama.useradmin.data.model.User
import com.sama.useradmin.data.repository.local.Db
import com.sama.useradmin.data.repository.local.UserDao
import com.sama.useradmin.data.repository.remote.CloudDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val cloudDataSource: CloudDataSource,
    private val db: Db,
    private val userDao: UserDao
) : Repository {

    override fun getRegularUsers(): LiveData<List<User>> {
        return userDao.getRegularUser()
    }

    override fun signUpRegularUser(
        fullname: String,
        email: String,
        password: String,
        image: String
    ): User {
        val user = User(
            USER_ROLE.REGULAR,
            fullname,
            email,
            password,
            image
        )
        GlobalScope.launch(Dispatchers.IO) {
            userDao.insert(
                user
            )
        }
        return user
    }

}