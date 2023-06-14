package data.dataSources

import com.example.domain.Auction
import com.google.gson.Gson
import data.models.CreateAuctionRequestModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Retrofit
import data.retrofitInterfaces.AuctionApi
import kotlinx.coroutines.*
import okhttp3.RequestBody
import okhttp3.internal.wait
import javax.inject.Inject

class AuctionsRemoteDataSource @Inject constructor(
    private val retrofit: Retrofit,

) {
    private val auctionApi: AuctionApi = retrofit.create(AuctionApi::class.java)
    private val gson = Gson()

    private fun createRequestBody(model: Any): RequestBody{
        return gson.toJson(model).toRequestBody("application/json".toMediaTypeOrNull())
    }

    private suspend fun executeCoroutine(model: Any) = coroutineScope {
        return@coroutineScope async { auctionApi.createAuction(createRequestBody(model)) }
        /* CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main){
                return@withContext response
            }
        }*/
    }

    suspend fun createAuction(auction: Auction) : String {
        val model = CreateAuctionRequestModel(auction.addressFrom.street, auction.addressTo.street)
        executeCoroutine(model).await()
        /*val jsonObject = JSONObject()
        jsonObject.put("from", auction.addressFrom.street)
        jsonObject.put("to", auction.addressTo.street)
        val jsonObjectString = jsonObject.toString()
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())*/
        var api : String
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
               api = "ad"
            }
        }.wait()
        return api
    }
}