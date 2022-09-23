package com.example.tfe.data.entity

import android.os.Parcelable
import androidx.room.*
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    tableName = "Book",
    foreignKeys = [ForeignKey(
        entity = Directory::class,
        parentColumns = arrayOf("directory_id"),
        childColumns = arrayOf("book_directory")
    )]
)
data class Book constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id")
    var bookId: Int = -1,
    @ColumnInfo(name = "book_name")
    var title: String,
    @ColumnInfo(name = "book_authors")
    var authors: String,
    @ColumnInfo(name = "book_isbn")
    var isbn: String,
    @ColumnInfo(name = "book_directory")
    var directory: Int
) : Parcelable
