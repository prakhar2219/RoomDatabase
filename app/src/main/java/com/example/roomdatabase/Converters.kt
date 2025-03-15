package com.example.roomdatabase

import androidx.room.TypeConverter
import java.util.Date

class Converters {
    @TypeConverter
    fun fromDateToLong(value: Date?): Long? {  // Allow null
        return value?.time
    }

    @TypeConverter
    fun fromLongToDate(value: Long?): Date? {  // Allow null
        return value?.let { Date(it) }
    }
}
