package com.example.domain.repositories

import com.example.domain.entities.Auction

interface AuctionsRepository {
    suspend fun createAuction(auction: Auction): Auction?
}