package com.example.domain.repositories

import com.example.domain.entities.Response
import com.example.domain.entities.UserAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow


@ExperimentalCoroutinesApi
interface UserRepository {

    suspend fun registerUser(userAuth: UserAuth) : Flow<Response<Boolean>>
}