package be.bf.kit3tsu.connect_the_books.data.entities

import androidx.room.Entity

@Entity(primaryKeys = ["note_id","tag_id"])
data class NoteTagCrossRef(
    val note_id : Int,
    val tag_id : Int
)
