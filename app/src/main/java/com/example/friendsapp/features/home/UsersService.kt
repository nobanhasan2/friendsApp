package com.example.friendsapp.features.home

import com.example.friendsapp.features.home.model.UserResults
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersService
@Inject constructor(retrofit: Retrofit) : UsersApi{
    private val usersApi by lazy { retrofit.create(UsersApi::class.java) }
    override fun getUsers() =usersApi.getUsers()
}