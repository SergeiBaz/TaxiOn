package com.example.data.storage.local_db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.storage.local_db.entities.AuctionDbEntity
import com.example.data.storage.local_db.entities.UserDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM ${UserDbEntity.TABLE_NAME}")
    suspend fun getUsersList(): Flow<List<UserDbEntity>>

    @Insert(entity = UserDbEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: UserDbEntity)

    @Delete(entity = UserDbEntity::class)
    suspend fun deleteUser(user: UserDbEntity)

    @Query("SELECT * FROM ${AuctionDbEntity.TABLE_NAME}")
    suspend fun getAuctionList(): Flow<List<AuctionDbEntity>>

    @Insert(entity = AuctionDbEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAuction(auction: AuctionDbEntity)

}