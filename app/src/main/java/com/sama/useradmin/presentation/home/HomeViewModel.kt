package com.sama.useradmin.presentation.home

import androidx.lifecycle.*
import com.sama.useradmin.data.model.User
import com.sama.useradmin.data.repository.Repository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){

    private val allUsers = MediatorLiveData<List<User>>()
    fun getAllUsers() = allUsers as LiveData<List<User>>

    fun getRegularUsers(){
        allUsers.addSource(repository.getRegularUsers()){
            print(it[0].email)
        }
    }
}