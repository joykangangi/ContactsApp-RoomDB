package com.example.contactsroom.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")

data class UserEntity(
   @ColumnInfo(name = "user_email")
   var emailAdd: String,
   @ColumnInfo(name = "user_password")
   var password: String
   ) {
    //setting id here to avoid initializing it manually in the constructor
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}
