package di.repositories

import com.example.domain.Auction
import com.example.service.AuctionsRepository
import data.dataSources.AuctionsRemoteDataSource
import javax.inject.Inject

class AuctionsRepository @Inject constructor(
    private val auctionsRemoteDataSource: AuctionsRemoteDataSource
) : AuctionsRepository {
    override suspend fun createAuction(auction: Auction): Auction? {
        return auctionsRemoteDataSource.createAuction(auction)
    }
}