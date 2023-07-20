package com.example.data.dataSources

import com.example.data.storage.local_db.dao.Dao
import com.example.data.storage.local_db.db.LocalSource
import com.example.data.storage.local_db.entities.AuctionDbEntity
import com.example.data.storage.local_db.entities.UserDbEntity
import javax.inject.Inject

class AuctionsLocalDataSource @Inject constructor(
    private val dao: Dao
) : LocalSource {
    override suspend fun addUser(user: UserDbEntity) {
        return dao.addUser(user)
    }

    override suspend fun addAuction(auction: AuctionDbEntity) {
        return dao.addAuction(auction)
    }

    override suspend fun getAuctionsList() {
        TODO("Not yet implemented")
    }
}