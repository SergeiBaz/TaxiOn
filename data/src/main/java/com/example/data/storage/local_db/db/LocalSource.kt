package com.example.data.storage.local_db.db

import com.example.data.storage.local_db.entities.AuctionDbEntity
import com.example.data.storage.local_db.entities.UserDbEntity

interface LocalSource {
    suspend fun addUser(user: UserDbEntity)

    suspend fun addAuction(auction: AuctionDbEntity)

    suspend fun getAuctionsList()
}