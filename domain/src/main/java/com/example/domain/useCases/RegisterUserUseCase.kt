package com.example.domain.useCases

import com.example.domain.entities.Response
import com.example.domain.entities.UserAuth
import com.example.domain.repositories.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class RegisterUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(
        userAuth: UserAuth
    ): Flow<Response<Boolean>> {
        return repository.registerUser(userAuth)
    }
}
