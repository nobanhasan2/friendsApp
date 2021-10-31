package com.example.friendsapp.features.home.domain



import com.example.friendsapp.core.interactor.UseCase
import com.example.friendsapp.features.home.UsersRepository
import com.example.friendsapp.features.home.model.UserResults
import javax.inject.Inject

class GetUsers @Inject constructor(private val userRepository: UsersRepository): UseCase<UserResults, GetUsers.Params>(){

    data class Params(val username: String,val password:String)

    override suspend fun run(params: Params) = userRepository.getUsers()
}