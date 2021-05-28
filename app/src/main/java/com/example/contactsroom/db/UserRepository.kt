package com.example.contactsroom.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.contactsroom.db.dao.UserDao
import com.example.contactsroom.db.entities.UserEntity
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


//implement mthds used to access the database(frm dao object)
class UserRepository (context: Context) {
    private val db = UserDatabase.invoke(context) //instance of database

   fun isAccountExisting(userEmail: String?) = db.getUserDao().isDataExist(userEmail)

    fun upsertUser(userEntity: UserEntity) {//relate with the database
GlobalScope.launch {
    withContext(Dispatchers.IO) {
        db.getUserDao().upsert(userEntity)
    }
}
    }
}