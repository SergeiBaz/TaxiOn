package com.example.domain.repositories

import com.example.domain.entities.Auction

interface AuctionsRepository {
    suspend fun createAuction(auction: Auction): Auction?
    suspend fun getAuction(id: Int): Auction?
    suspend fun addCandidate(auctionId: Int, userId: String): Auction?
    suspend fun getAuctionsArray(): List<Auction>?


}