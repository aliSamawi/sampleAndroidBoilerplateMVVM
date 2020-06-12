package com.sama.useradmin.data.repository

import androidx.lifecycle.LiveData
import com.sama.useradmin.data.model.User

interface Repository{
    fun getRegularUsers(): LiveData<List<User>>

    fun signUpRegularUser(fullname:String, email:String, password:String, image:String) : User

    fun loginUser(email: String, password: String) : LiveData<User?>
}