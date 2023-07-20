package com.example.data.storage.local_db.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.storage.local_db.dao.Dao
import com.example.data.storage.local_db.entities.AuctionDbEntity
import com.example.data.storage.local_db.entities.UserDbEntity

@Database(
    version = 1,
    entities = [UserDbEntity::class, AuctionDbEntity::class]
)
abstract class Database : RoomDatabase() {
    abstract fun getDao(): Dao
}