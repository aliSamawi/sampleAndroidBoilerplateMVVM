package com.sama.useradmin.presentation.profile

import android.util.Patterns
import androidx.lifecycle.*
import com.sama.useradmin.data.model.AccountManager
import com.sama.useradmin.data.model.USER_ROLE
import com.sama.useradmin.data.model.User
import com.sama.useradmin.data.repository.Repository
import java.util.regex.Pattern
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){

    val validationError = MutableLiveData<String>()
    val updateSuccess = MediatorLiveData<User>()

    fun getCurrentUser() = AccountManager.getCurrentUser()

    fun logoutUser(){
        AccountManager.logoutUser()
    }

    fun removeCurrentUser() {
        AccountManager.logoutUser()
    }

    fun updateCurrentUser(email:String, password:String, fullname:String, image:String){
        if (email.isEmpty()){
            validationError.value = "email should not be empty."
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            validationError.value = "please enter valid email address."
            return
        }

        if (password.isEmpty()){
            validationError.value = "password should not be empty."
            return
        }
        if (!Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$").matcher(password).matches()){
            validationError.value = "Password field must contain numerical and capital values."
            return
        }

        val user = repository.insertUser(fullname, USER_ROLE.REGULAR,email,password,image)
        AccountManager.insertUser(user)
        updateSuccess.value = user
    }
}