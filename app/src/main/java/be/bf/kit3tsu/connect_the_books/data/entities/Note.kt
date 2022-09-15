package be.bf.kit3tsu.connect_the_books.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import be.bf.kit3tsu.connect_the_books.util.Visibility

@Entity(tableName = "Note")
data class Note constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    var noteId: Int? = null,
    @ColumnInfo(name = "note_name")
    var name: String,
    @ColumnInfo(name = "note_description")
    var description: String,
    @ColumnInfo(name = "note_path")
    var path: String,
    @ColumnInfo(name = "note_visibility")
    var visibility: Visibility,
    @ColumnInfo(name = "note_directory")
    var parentDirectory: Int
)