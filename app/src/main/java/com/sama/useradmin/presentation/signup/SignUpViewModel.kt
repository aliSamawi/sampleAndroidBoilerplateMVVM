package com.sama.useradmin.presentation.signup

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sama.useradmin.data.model.AccountManager
import com.sama.useradmin.data.model.USER_ROLE
import com.sama.useradmin.data.model.User
import com.sama.useradmin.data.repository.Repository
import java.util.regex.Pattern
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    val repository: Repository
): ViewModel(){

    val validationError = MutableLiveData<String>()
    val signupSuccess = MutableLiveData<User>()

    fun signUpUser(fullname:String, email: String, password:String, confirmPassword:String){
        if (fullname.isEmpty()){
            validationError.value = "fullname should not be empty."
            return
        }

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

        if (confirmPassword.isEmpty()){
            validationError.value = "confirm password should not be empty."
            return
        }
        if (confirmPassword != password){
            validationError.value = "confirm password should not be different with password."
            return
        }

        val user = repository.insertUser(fullname,USER_ROLE.REGULAR,email,password,"") //todo set image address
        AccountManager.insertUser(user)
        signupSuccess.value = user

    }
}