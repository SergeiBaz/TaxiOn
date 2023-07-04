package com.example.data.repositories

import com.example.domain.entities.Auction
import com.example.domain.repositories.AuctionsRepository
import javax.inject.Inject

class AuctionsRepository @Inject constructor(
    private val auctionsRemoteDataSource: com.example.data.dataSources.AuctionsRemoteDataSource
) : AuctionsRepository {
    override suspend fun createAuction(auction: Auction): Auction? {
        return auctionsRemoteDataSource.createAuction(auction)
    }

    override suspend fun getAuction(id: Int): Auction? {
        TODO("Not yet implemented")
    }

    override suspend fun addCandidate(auctionId: Int, userId: Int): Auction? {
        return auctionsRemoteDataSource.addCandidate(auctionId, userId)
    }
}