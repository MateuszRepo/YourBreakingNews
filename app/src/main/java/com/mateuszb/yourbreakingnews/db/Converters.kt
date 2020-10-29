package com.mateuszb.yourbreakingnews.db

import androidx.room.TypeConverter
import com.mateuszb.yourbreakingnews.models.Source

class Converters {

    @TypeConverter
    fun fromSourceToString(source: Source) = source.name

    @TypeConverter
    fun fromStringToSource(name: String) = Source(name, name)
}