package com.example.contactsroom.db.dao

import androidx.room.*
import com.example.contactsroom.db.entities.UserEntity

@Dao

interface UserDao {
    @Query("SELECT * FROM user")
    fun selectAllUsers(): List<UserEntity>

    @Insert
    fun insertUser(userEntity: UserEntity)

    @Delete
    fun deleteUser(userEntity: UserEntity)

    @Update
    fun updateUser(userEntity: UserEntity)
}