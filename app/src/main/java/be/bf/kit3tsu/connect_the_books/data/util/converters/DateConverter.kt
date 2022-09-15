package be.bf.kit3tsu.connect_the_books.data.util.converters

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.LocalDate

class DateConverter {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @TypeConverter
    fun fromTimestamp(value: String?): LocalDate? {
        return if (value == null) null else LocalDate.parse(value)
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): String? {
        return date?.toString()
    }
}