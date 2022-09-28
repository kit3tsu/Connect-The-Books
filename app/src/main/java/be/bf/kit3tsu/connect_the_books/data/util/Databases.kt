package be.bf.kit3tsu.connect_the_books.data.util

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import be.bf.kit3tsu.connect_the_books.data.dao.BookDao
import be.bf.kit3tsu.connect_the_books.data.dao.DirectoryDao
import be.bf.kit3tsu.connect_the_books.data.dao.NoteDao
import be.bf.kit3tsu.connect_the_books.data.dao.TagDao
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.data.entities.NoteTagCrossRef
import be.bf.kit3tsu.connect_the_books.data.entities.Tag
import be.bf.kit3tsu.connect_the_books.data.util.converters.DateConverter
import be.bf.kit3tsu.connect_the_books.data.util.converters.EntityConverters
import be.bf.kit3tsu.connect_the_books.data.util.converters.EnumConverter
import be.bf.kit3tsu.connect_the_books.data.entities.Book

@Database(
    entities = [Book::class, Note::class,Tag::class,Directory::class,NoteTagCrossRef::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(EnumConverter::class,DateConverter::class,EntityConverters::class)
abstract class Databases : RoomDatabase() {
    companion object {
        private var instance: Databases? = null
        fun instance(context: Context): Databases {
            if (instance == null) {
                val room = Room
                    .databaseBuilder(context, Databases::class.java, "app_db")
                Log.d("Databases", "instance: $room")
                room.allowMainThreadQueries()
                instance = room.build()
            }
            return instance!!
        }
    }
    abstract fun bookDao(): BookDao
    abstract fun noteDao(): NoteDao
    abstract fun directoryDao(): DirectoryDao
    abstract fun tagDao(): TagDao
}