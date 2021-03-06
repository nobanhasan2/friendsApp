package com.example.friendsapp.core.auth

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Authenticator
@Inject constructor() {
    //Learning purpose: We assume the user is always logged in
    //Here you should put your own logic to return whether the user
    //is authenticated or not
    var isLoggedIn = false
    fun userLoggedIn() = isLoggedIn
}
