package com.sama.useradmin.presentation.login

import android.util.Patterns
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sama.useradmin.data.model.User
import com.sama.useradmin.data.repository.Repository
import java.util.regex.Pattern
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    val repository: Repository
): ViewModel(){

    val validationError = MutableLiveData<String>()
    val loginSuccess = MediatorLiveData<User>()

    fun loginUser(email: String, password:String){
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

        loginSuccess.addSource(repository.loginUser(email,password)){
            if (it == null){
                validationError.postValue("email or password is incorrect!")
            }else {
                loginSuccess.postValue(it)
            }
        }

    }
}