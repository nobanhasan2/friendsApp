package com.example.friendsapp.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.friendsapp.core.platform.BaseViewModel
import com.example.friendsapp.features.home.domain.GetUsers
import com.example.friendsapp.features.home.model.UserResults
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsers: GetUsers
) :BaseViewModel(){


    private val _userResult: MutableLiveData<UserResults> = MutableLiveData()
    val userResult: LiveData<UserResults> = _userResult

    fun getUsersList(){
        loadingStatus.value = true
        getUsers(GetUsers.Params("",""),viewModelScope){
            it.fold(::handleFailure, ::handleOnSuccessLogin)
        }
    }
    private fun handleOnSuccessLogin(userResult: UserResults) {
        loadingStatus.value = false
        _userResult.value = userResult
    }
}