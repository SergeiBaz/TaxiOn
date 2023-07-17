package com.example.data.repositories

import com.example.data.storage.interfaces.UserAuthStorage
import com.example.domain.entities.Response
import com.example.domain.entities.UserAuth
import com.example.domain.repositories.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalCoroutinesApi
class UserRepository @Inject constructor(
    private val userAuthStorage: UserAuthStorage
) : UserRepository {
    override suspend fun registerUser(
        userAuth: UserAuth
    ): Flow<Response<Boolean>> {
        return userAuthStorage.register(userAuth)
    }
}