package be.bf.kit3tsu.connect_the_books.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import be.bf.kit3tsu.connect_the_books.util.Visibility

@Entity(tableName = "Note")
data class Note constructor (
    @ColumnInfo(name = "note_name")
    var name:String,
    @ColumnInfo(name = "note_description")
    var description: String,
    @ColumnInfo(name = "note_path")
    var path: String,
    @ColumnInfo(name = "note_visibility")
    var visibility: Visibility,
    @ColumnInfo(name= "note_directory")
    var parentDirectory : Int,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    var noteId: Int? = null,
) {}
//{
//
//    constructor(noteId: Int, name: String, description: String, path: String,visibility: Visibility,parentDirectory: Int,content: String) :
//            this(name, description, path,visibility,parentDirectory) {
//        this.noteId =noteId
//        this.content = content
//    }
//}
