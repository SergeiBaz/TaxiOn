package com.example.data.repositories
import com.example.data.dataSources.AuctionsLocalDataSource
import com.example.domain.entities.Auction
import com.example.domain.repositories.AuctionsRepository
import javax.inject.Inject

class AuctionsRepository @Inject constructor(
    private val auctionsRemoteDataSource: com.example.data.dataSources.AuctionsRemoteDataSource,
    private val auctionsLocalDataSource: AuctionsLocalDataSource
) : AuctionsRepository {
    override suspend fun createAuction(auction: Auction): Auction? {
        return auctionsRemoteDataSource.createAuction(auction)
    }

    override suspend fun getAuction(id: Int): Auction? {
        val data = auctionsRemoteDataSource.getAuction(id)

        return auctionsRemoteDataSource.getAuction(id)
    }

    override suspend fun addCandidate(auctionId: Int, userId: String): Auction? {
        return auctionsRemoteDataSource.addCandidate(auctionId, userId)
    }

    override suspend fun getAuctionsArray(): List<Auction>? {
        return auctionsRemoteDataSource.getAuctionsModelArray()
    }
}