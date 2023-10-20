package com.example.data.repositories
import com.example.data.models.CreateAuctionRequestModel
import com.example.data.retrofitInterfaces.AuctionApi
import com.example.domain.entities.Auction
import com.example.domain.repositories.AuctionsRepository
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Retrofit
import javax.inject.Inject

class AuctionsRepository @Inject constructor(
    private val retrofit: Retrofit,
) : AuctionsRepository {

    private val auctionApi: AuctionApi = retrofit.create(AuctionApi::class.java)
    private val gson = Gson()

    private fun createRequestBody(model: Any): RequestBody {
        return gson.toJson(model).toRequestBody("application/json".toMediaTypeOrNull())
    }

    override suspend fun createAuction(auction: Auction): Auction? {
        val model = CreateAuctionRequestModel(auction.from.street, auction.to.street)
        return auctionApi.createAuction(createRequestBody(model)).body()
    }

    override suspend fun getAuction(id: Int): Auction? {
        return auctionApi.getAuction(id).body()
    }

    override suspend fun addCandidate(auctionId: Int, userId: String): Auction? {
        return auctionApi.addCandidate(auctionId, userId.toRequestBody()).body()
    }

    override suspend fun getAuctionsArray(): List<Auction>? {
        return auctionApi.getAuctionsModelArray().body()
    }
}