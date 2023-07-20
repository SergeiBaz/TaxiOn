package com.example.data.storage.local_db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.storage.local_db.entities.AuctionDbEntity.Companion.TABLE_NAME
import com.example.domain.entities.Address
import com.example.domain.entities.Auction

@Entity(tableName = TABLE_NAME)
data class AuctionDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,
    @ColumnInfo("passengerId")
    val passId: String,
    @ColumnInfo("candidateIdCollection")
    val candidateIdCollection: String,
    @ColumnInfo("street")
    val from: String,
    val to: String
) {
    fun toAuction(): Auction = Auction(
        Address(from),
        Address(to)
    )

    companion object {
        const val TABLE_NAME = "auction_entity_table"
    }
}