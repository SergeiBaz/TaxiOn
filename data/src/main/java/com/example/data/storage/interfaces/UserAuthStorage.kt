package com.example.data.storage.interfaces

import com.example.domain.model.Response
import com.example.domain.model.UserAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
interface UserAuthStorage {

    suspend fun register(userAuth: UserAuth) : Flow<Response<Boolean>>
}