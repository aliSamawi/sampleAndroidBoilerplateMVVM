package com.sama.useradmin.presentation.home

import androidx.lifecycle.*
import com.sama.useradmin.data.repository.Repository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){

}