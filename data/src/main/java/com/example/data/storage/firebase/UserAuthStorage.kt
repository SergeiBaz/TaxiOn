package com.example.data.storage.firebase

import com.example.domain.entities.Response
import com.example.domain.entities.UserAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
interface UserAuthStorage {

    suspend fun register(userAuth: UserAuth) : Flow<Response<Boolean>>
}