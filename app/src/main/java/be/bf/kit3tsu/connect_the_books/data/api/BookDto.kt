package be.bf.kit3tsu.connect_the_books.data.api

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class BookDataDto(
    var title: String,
    var authors: String?,
    var isbn: String?
)
