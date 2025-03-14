package com.example.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {
//    in methods kaa implementation hum ae roomprovide krta hai
    @Insert
   suspend fun insertContact(contact: Contact)

    @Insert
   suspend fun updateContact(contact: Contact)

    @Insert
   suspend fun deleteContact(contact: Contact)
//Room jo hai wo LiveData ke sath compatible hai, liveData defined hai ,tlb wo task background thread pe execute hoga
    @Query("select * from contact")
    fun getContact():LiveData<List<Contact>>

}