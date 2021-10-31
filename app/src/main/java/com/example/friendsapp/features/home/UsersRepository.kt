package com.example.friendsapp.features.home

import com.example.friendsapp.core.api.ApiRequest
import com.example.friendsapp.core.exception.Failure
import com.example.friendsapp.core.functional.Either
import com.example.friendsapp.core.platform.NetworkHandler
import com.example.friendsapp.features.home.model.UserResults
import javax.inject.Inject

interface UsersRepository {

    fun getUsers(): Either<Failure, UserResults>
    class Network
    @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: UsersService
    ):UsersRepository, ApiRequest(){
        override fun getUsers(): Either<Failure, UserResults> {
            return when (networkHandler.isNetworkAvailable()) {
                true -> request(
                    service.getUsers(),
                    {it},
                    UserResults()
                )
                false -> Either.Left(Failure.NetworkConnection)
            }
        }
    }
}