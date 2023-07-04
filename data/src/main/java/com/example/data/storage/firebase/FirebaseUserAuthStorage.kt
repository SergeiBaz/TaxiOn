package com.example.data.storage.firebase

import com.example.data.storage.interfaces.UserAuthStorage
import com.example.domain.entities.Response
import com.example.domain.entities.UserAuth
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

@ExperimentalCoroutinesApi
class FirebaseUserAuthStorage : UserAuthStorage {

    companion object {
        private val fAuth = FirebaseAuth.getInstance()
    }

    override suspend fun register(userAuth: UserAuth): Flow<Response<Boolean>> = callbackFlow {
        trySend(Response.Loading())

        fAuth.createUserWithEmailAndPassword(userAuth.email.toString(), userAuth.password.toString())
            .addOnSuccessListener {
                trySend(Response.Success(data = true))
            }.addOnFailureListener { e ->
                trySend(Response.Fail(e = e))
            }
        awaitClose { this.cancel() }
    }
}
