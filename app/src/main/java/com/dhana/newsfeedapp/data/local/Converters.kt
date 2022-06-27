package com.dhana.newsfeedapp.data.local

import androidx.room.TypeConverter
import com.dhana.newsfeedapp.data.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name)
    }
}