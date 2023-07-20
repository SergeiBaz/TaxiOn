package com.example.data.storage.local_db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.storage.local_db.entities.UserDbEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class UserDbEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "login") val login: String,
    @ColumnInfo(name = "name") val name: String,
    val auto: String,
) {
    companion object {
        const val TABLE_NAME = "user_entity_table"
    }
}