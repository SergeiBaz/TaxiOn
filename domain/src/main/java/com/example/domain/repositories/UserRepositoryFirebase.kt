package com.example.domain.repositories

import com.example.domain.model.Response
import com.example.domain.model.UserAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow


@ExperimentalCoroutinesApi
interface UserRepositoryFirebase {
    suspend fun registerUser(userAuth: UserAuth) : Flow<Response<Boolean>>
}