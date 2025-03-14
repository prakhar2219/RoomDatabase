package com.example.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

//version will change when we will define new version of our app
//since there can be multiple enteries in the table so we will use array,and pass the entity name in it
@Database(entities = [Contact::class], version = 1))
abstract class ContactDatabase:RoomDatabase {
    abstract fun contactDao():ContactDao

}