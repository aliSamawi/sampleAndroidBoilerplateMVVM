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
        return userDao.getRegularUser(USER_ROLE.REGULAR.type)
    }

    override fun insertUser(
        fullname: String,
        role : USER_ROLE,
        email: String,
        password: String,
        image: String
    ): User {
        val user = User(
            role,
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

    override fun loginUser(email: String, password: String) =
        userDao.getUser(email, password)

    override fun updateUser(currentUser: User, newEmail: String, password: String) {
        GlobalScope.launch (Dispatchers.IO){
            // can't update directly because email is primary key
            userDao.delete(currentUser.email)
            userDao.insert(currentUser.copy(email = newEmail,password = password))
        }
    }

    override fun deleteUser(email: String) {
        GlobalScope.launch (Dispatchers.IO){
            userDao.delete(email)
        }
    }

}