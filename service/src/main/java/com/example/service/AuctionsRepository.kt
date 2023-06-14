package com.example.service

import com.example.domain.Auction

interface AuctionsRepository {
    suspend fun createAuction(auction: Auction)
}