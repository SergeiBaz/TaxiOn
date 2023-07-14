package com.example.domain.useCases

import com.example.domain.entities.Auction
import com.example.domain.repositories.AuctionsRepository

class GetAuctionUseCase(private val auctionsRepository: AuctionsRepository) {
    suspend operator fun invoke(id: Int): Auction? {
        return auctionsRepository.getAuction(id)
    }
}