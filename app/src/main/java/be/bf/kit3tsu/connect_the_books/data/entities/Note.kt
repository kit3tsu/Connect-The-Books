package be.bf.kit3tsu.connect_the_books.data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import be.bf.kit3tsu.connect_the_books.data.util.Visibility
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Note")
data class Note constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    var noteId: Int? = null,
    @ColumnInfo(name = "note_title")
    var title: String,
    @ColumnInfo(name = "note_content")
    var content: String,
    @ColumnInfo(name = "note_visibility")
    var visibility: Visibility,
    @ColumnInfo(name = "directory_id")
    var parentDirectory: Int? = 1
) : Parcelable