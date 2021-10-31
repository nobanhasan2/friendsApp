package com.example.friendsapp.core.api

import com.example.friendsapp.core.exception.Failure
import com.example.friendsapp.core.functional.Either
import retrofit2.Call

open class ApiRequest {
    fun <T, R> request(
            call: Call<T>,
            transform: (T) -> R,
            default: T
    ): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Either.Right(transform((response.body() ?: default)))
                false -> Either.Left(Failure.ServerError)
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError)
        }
    }
}