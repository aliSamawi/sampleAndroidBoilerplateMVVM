package com.sama.useradmin.presentation.admin_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.sama.useradmin.data.model.User
import com.sama.useradmin.data.repository.Repository
import javax.inject.Inject

class AdminListViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val getUsers = MediatorLiveData<List<User>>()

    fun getRegularUsers() : LiveData<List<User>>{
        getUsers.addSource(repository.getRegularUsers()){
            getUsers.postValue(it)
        }
        return getUsers
    }

    fun removeUser(email : String){
        repository.deleteUser(email)
    }
}