package com.sama.useradmin.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor() : ViewModel(){

    val splashLiveData: LiveData<SplashState>
        get() = mutableLiveData

    private val mutableLiveData = MutableLiveData<SplashState>()
    init {
        GlobalScope.launch {
            delay(2000)
            mutableLiveData.postValue(SplashState.HomeActivity())
        }
    }
}

sealed class SplashState {
    class HomeActivity : SplashState()
}