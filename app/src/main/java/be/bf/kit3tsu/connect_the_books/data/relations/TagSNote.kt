package be.bf.kit3tsu.connect_the_books.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.data.entities.NoteTagCrossRef
import be.bf.kit3tsu.connect_the_books.data.entities.Tag

data class TagSNote(
    @Embedded val tag: Tag,
    @Relation(
        parentColumn = "tag_id",
        entityColumn = "note_id",
        associateBy = Junction(NoteTagCrossRef::class)
    )
    val notes: List<Note>
)
