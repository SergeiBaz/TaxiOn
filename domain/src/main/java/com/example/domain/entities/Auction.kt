package com.example.domain.entities

import com.example.domain.model.Address

class Auction(
    var from: Address,
    var to: Address,
) {
    val id: Int = 0
    val passengerId: String = ""
    val candidateIdCollection: MutableList<String> = ArrayList()
    val candidates: MutableList<Driver> = ArrayList()
    fun addCandidate(driver: Driver) {
        candidates.add(driver)
    }
}