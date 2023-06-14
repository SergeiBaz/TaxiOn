package data.repositories

import com.example.domain.Auction
import com.example.service.AuctionsRepository
import data.dataSources.AuctionsRemoteDataSource
import javax.inject.Inject

class AuctionsRepository @Inject constructor (
    private val auctionsRemoteDataSource: AuctionsRemoteDataSource
) : AuctionsRepository {
    override suspend fun createAuction(auction: Auction) {
        auctionsRemoteDataSource.createAuction(auction)
    }
}