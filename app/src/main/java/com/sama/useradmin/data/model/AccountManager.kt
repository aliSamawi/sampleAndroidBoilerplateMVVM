package com.sama.useradmin.data.model

import com.orhanobut.hawk.Hawk

object AccountManager {

    private val USER_KEY = "USER_KEY"

    fun getCurrentUser() : User?{
        return Hawk.get(USER_KEY)
    }

    fun insertUser(user : User){
        Hawk.put(USER_KEY, user)
    }

    fun logoutUser(){
        Hawk.delete(USER_KEY)
    }
}