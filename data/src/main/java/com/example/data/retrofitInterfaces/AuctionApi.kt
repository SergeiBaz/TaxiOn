package com.example.data.retrofitInterfaces

import com.example.domain.entities.Auction
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface AuctionApi {
    @POST("/api/auctions")
    suspend fun createAuction(@Body requestBody: RequestBody): Response<Auction>
    @POST("/api/auctions/{auctionId}/candidates")
    suspend fun addCandidate(@Path("auctionId") auctionId: Int, @Body requestBody: RequestBody): Response<Auction>
}
