package com.example.friendsapp.features.home

import com.example.friendsapp.features.home.model.UserResults
import retrofit2.Call
import retrofit2.http.GET

interface UsersApi {

    companion object {
        private const val USERS_LIST = "api/?page=1&results=10"

    }
    @GET(USERS_LIST)
    fun getUsers(): Call<UserResults>
}