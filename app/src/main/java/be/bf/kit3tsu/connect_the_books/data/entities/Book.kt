package com.example.tfe.data.entity

import androidx.room.*
import be.bf.kit3tsu.connect_the_books.data.entities.Directory

@Entity(tableName = "Book",
foreignKeys = [ForeignKey(entity = Directory::class,
    parentColumns = arrayOf("directory_id"),
    childColumns = arrayOf("book_directory"))]
)
data class Book @Ignore constructor(
    @ColumnInfo(name = "book_name")
    var title: String,
    @ColumnInfo(name = "book_authors")
    var authors: String,
    @ColumnInfo(name = "book_isbn")
    var isbn: String,
    @ColumnInfo(name = "book_directory")
    var directory: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id")
    var bookId: Int = -1
    //TODO change authors type when create author data
    constructor(bookId: Int, title: String, authors: String, isbn: String,directory: Int): this(title, authors,isbn,directory) {
        this.bookId = bookId
    }
}