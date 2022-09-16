package be.bf.kit3tsu.connect_the_books.data.util.converters

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import be.bf.kit3tsu.connect_the_books.data.entities.Tag
import be.bf.kit3tsu.connect_the_books.data.util.Visibility

class EnumConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toVisibility(value: String?): Visibility? {
         if (value == "PUBLIC") {
            return Visibility.PUBLIC
        } else if (value == "PRIVATE"){
            return Visibility.PRIVATE
        }else{
            return null
         }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromVisibility(value : Visibility) : String {
        return value.toString()
    }

}