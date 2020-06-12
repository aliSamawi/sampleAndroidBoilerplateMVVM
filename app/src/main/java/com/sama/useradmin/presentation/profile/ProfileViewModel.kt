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
    val updateSuccess = MutableLiveData<Boolean>()

    fun getCurrentUser() = AccountManager.getCurrentUser()

    fun logoutUser(){
        AccountManager.logoutUser()
    }

    fun removeCurrentUser() {
        AccountManager.getCurrentUser()?.email?.let { repository.deleteUser(it) }
        AccountManager.logoutUser()
    }

    fun updateCurrentUser(newEmail:String, password:String){
        if (newEmail.isEmpty()){
            validationError.value = "email should not be empty."
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(newEmail).matches()){
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

        val currentUser = getCurrentUser()
        currentUser?.let {
            repository.updateUser(currentUser,newEmail,password)
            AccountManager.updateUser(currentUser.copy(email = newEmail,password = password))
            updateSuccess.value = true
        }
    }
}