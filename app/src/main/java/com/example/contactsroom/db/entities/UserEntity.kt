package com.example.contactsroom.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")

data class UserEntity(
   @PrimaryKey(autoGenerate = true) var id: Int,
   @ColumnInfo var emailAdd: String,
   @ColumnInfo var password: String
)
