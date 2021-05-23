package com.example.contactsroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactsroom.db.dao.UserDao
import com.example.contactsroom.db.entities.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile private var instance: UserDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
         instance?: buildInterface(context)
        }
        private fun buildInterface(context: Context) = Room.databaseBuilder(context, UserDatabase::class.java, "user.db").build()

    }

}