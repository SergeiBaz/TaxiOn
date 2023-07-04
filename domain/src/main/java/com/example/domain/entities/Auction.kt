package com.example.domain.entities

class Auction(
    var from: Address,
    var to: Address,
) {
    val candidates: MutableList<Driver> = ArrayList()
    fun addCandidate(driver: Driver) {
        candidates.add(driver)
    }
}