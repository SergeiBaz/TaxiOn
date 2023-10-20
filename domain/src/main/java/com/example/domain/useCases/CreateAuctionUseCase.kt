package com.example.domain.useCases

import com.example.domain.entities.Address
import com.example.domain.entities.Auction
import com.example.domain.repositories.AuctionsRepository

class CreateAuctionUseCase(
    private val repository: AuctionsRepository
) {
    suspend operator fun invoke(
        streetFrom: String,
        streetTo: String,
    ): Auction? {
        val addressFrom = Address(streetFrom)
        val addressTo = Address(streetTo)
        val auction = Auction(addressFrom, addressTo)
        return repository.createAuction(auction)
    }
}