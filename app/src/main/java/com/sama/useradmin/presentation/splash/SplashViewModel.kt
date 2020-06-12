package com.sama.useradmin.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sama.useradmin.data.model.AccountManager
import com.sama.useradmin.data.model.USER_ROLE
import com.sama.useradmin.data.repository.Repository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(val repository: Repository) : ViewModel(){

    val splashLiveData: LiveData<SplashState>
        get() = mutableLiveData

    private val mutableLiveData = MutableLiveData<SplashState>()
    init {
        GlobalScope.launch {
            repository.insertUser("admin",USER_ROLE.ADMIN,"admin@admin.com","123456aA","") //add admin user

            delay(2000)
            val user = AccountManager.getCurrentUser()
            when {
                user == null -> {
                    mutableLiveData.postValue(SplashState.Login())
                }
                user.role == USER_ROLE.REGULAR -> {
                    mutableLiveData.postValue(SplashState.Regular())
                }
                else -> {
                    mutableLiveData.postValue(SplashState.Admin())
                }
            }
        }
    }
}

sealed class SplashState {
    class Login : SplashState()
    class Regular : SplashState()
    class Admin : SplashState()
}