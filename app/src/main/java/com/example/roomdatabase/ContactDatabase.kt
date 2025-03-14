package com.example.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

//version will change when we will define new version of our app
//since there can be multiple enteries in the table so we will use array,and pass the entity name in it
@Database(entities = [Contact::class], version = 1)
@TypeConverters(Convertors::class)
abstract class ContactDatabase:RoomDatabase {
    abstract fun contactDao():ContactDao

//    implementing singleton pattern
    companion object{
//        jaise hi INSTANCE wale variable me koi bhi cahnges hoti hai to wo saare threads ko bta di jaati hai ki iski value change hua hai
        @Volatile
        private var INSTANCE:ContactDatabase?=null
//        public method to access the above
    fun getDatabase(context: Context):ContactDatabase{
        if (INSTANCE==null){
            synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "contactDB"
                ).build()
            }
        }
    return INSTANCE!!
    }
    }

}