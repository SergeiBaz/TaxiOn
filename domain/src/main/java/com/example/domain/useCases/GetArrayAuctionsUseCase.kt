package com.example.domain.useCases

import com.example.domain.entities.Auction
import com.example.domain.repositories.AuctionsRepository

class GetArrayAuctionsUseCase(private val auctionsRepository: AuctionsRepository) {
    suspend operator fun invoke(): List<Auction>? {
        return auctionsRepository.getAuctionsArray()
    }
}