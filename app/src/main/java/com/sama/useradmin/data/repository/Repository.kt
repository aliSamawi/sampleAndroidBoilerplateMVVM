package com.sama.useradmin.data.repository

import androidx.lifecycle.LiveData
import com.sama.useradmin.data.model.USER_ROLE
import com.sama.useradmin.data.model.User

interface Repository{
    fun getRegularUsers(): LiveData<List<User>>

    fun insertUser(fullname:String, role:USER_ROLE, email:String, password:String, image:String) : User

    fun loginUser(email: String, password: String) : LiveData<User?>

    fun updateUser(currentUser: User, newEmail: String, password: String)

    fun deleteUser(email:String)
}