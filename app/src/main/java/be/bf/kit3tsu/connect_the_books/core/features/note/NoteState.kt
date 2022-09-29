package be.bf.kit3tsu.connect_the_books.core.features.note

import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.data.util.Visibility

data class NoteState(
    val note: Note = Note(-1,"","","",Visibility.PUBLIC,0)
)
