package be.bf.kit3tsu.connect_the_books.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.entities.Note

data class DirectorySNote(
    @Embedded
    val directory: Directory,
    @Relation(
        parentColumn = "directory_id",
        entityColumn = "note_directory"
    )
    val notes: List<Note>
)

