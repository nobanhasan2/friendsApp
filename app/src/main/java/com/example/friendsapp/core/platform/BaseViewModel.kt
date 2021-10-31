package com.example.friendsapp.core.platform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.friendsapp.core.exception.Failure

/**
 * Base ViewModel class with default Failure handling.
 * @see ViewModel
 * @see Failure
 */
abstract class BaseViewModel : ViewModel() {

    private val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure
    var loadingStatus : MediatorLiveData<Boolean> = MediatorLiveData()

    protected fun handleFailure(failure: Failure) {
        loadingStatus.value = false
        _failure.value = failure
    }
}