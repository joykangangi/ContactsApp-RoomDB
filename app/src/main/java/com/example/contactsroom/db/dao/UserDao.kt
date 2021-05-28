package com.example.contactsroom.db.dao

import androidx.room.*
import com.example.contactsroom.db.entities.UserEntity

@Dao
//methods to access database
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //do update or insert user data
    fun upsert(userEntity: UserEntity)

    @Delete
    fun delete(userEntity: UserEntity)

   // @Query("SELECT * FROM user")
   // fun isDataExist(userEntity: UserEntity): Int

    @Query("SELECT * FROM user WHERE user_email = :userEmail")
    fun isDataExist(userEmail: String?): Int
}