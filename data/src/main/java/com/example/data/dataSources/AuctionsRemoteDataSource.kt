package com.example.data.dataSources

import com.example.data.models.CreateAuctionRequestModel
import com.example.data.retrofitInterfaces.AuctionApi
import com.example.domain.entities.Auction
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Retrofit
import okhttp3.RequestBody
import javax.inject.Inject

class AuctionsRemoteDataSource @Inject constructor(
    retrofit: Retrofit,
) {
    private val auctionApi: AuctionApi = retrofit.create(AuctionApi::class.java)
    private val gson = Gson()

    private fun createRequestBody(model: Any): RequestBody {
        return gson.toJson(model).toRequestBody("application/json".toMediaTypeOrNull())
    }

    suspend fun createAuction(auction: Auction): Auction? {
        val model = CreateAuctionRequestModel(auction.from.street, auction.to.street)
        return auctionApi.createAuction(createRequestBody(model)).body()
    }
}