package com.example.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {
    //    in methods kaa implementation hum ae roomprovide krta hai
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)
    //Room jo hai wo LiveData ke sath compatible hai, liveData defined hai ,tlb wo task background thread pe execute hoga
    @Query("SELECT * FROM contact")
    fun getContact():LiveData<List<Contact>>

}