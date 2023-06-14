package com.example.service

import com.example.domain.Address
import com.example.domain.Auction

class CreateAuctionUseCase(private val repository: AuctionsRepository) {
    suspend fun execute(streetFrom: String, streetTo: String) {
        val addressFrom = Address(streetFrom)
        val addressTo = Address(streetTo)
        val auction = Auction(addressFrom, addressTo)
        repository.createAuction(auction)
    }
}