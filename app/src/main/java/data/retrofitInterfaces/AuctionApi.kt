package data.retrofitInterfaces

import com.example.domain.Auction
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuctionApi {
    @POST("/api/auctions")
    suspend fun createAuction(@Body requestBody: RequestBody): Response<Auction>
}
