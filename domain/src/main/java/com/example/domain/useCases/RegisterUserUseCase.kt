package com.example.domain.useCases

import com.example.domain.model.Response
import com.example.domain.model.UserAuth
import com.example.domain.repositories.UserRepositoryFirebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class RegisterUserUseCase(
    private val repository: UserRepositoryFirebase
) {
    suspend operator fun invoke(
        userAuth: UserAuth
    ): Flow<Response<Boolean>> {
        return repository.registerUser(userAuth)
    }
}
