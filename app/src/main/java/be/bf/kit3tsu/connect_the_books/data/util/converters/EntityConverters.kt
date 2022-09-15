package be.bf.kit3tsu.connect_the_books.data.util.converters

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import be.bf.kit3tsu.connect_the_books.data.entities.Tag
import java.lang.Integer.parseInt

class EntityConverters {
    @TypeConverter
    fun toTag(value: String?): Tag? {
        return if(value == null ) null else {
            val parts = value.split("-").toTypedArray()
            val id = Integer.parseInt(parts[0])
            val name = parts[1]
            return Tag(id, name)
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromTag(value : Tag) : String {
        return value.tagId.toString() + "-" + value.name
    }
}