package be.bf.kit3tsu.connect_the_books.core.features.note

import be.bf.kit3tsu.connect_the_books.core.features.directory.DirectoryEvent
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.entities.Note

sealed class NoteEvent {
    data class AddNote(val note: Note) : NoteEvent()
    data class DeleteNote(val note: Note) : NoteEvent()
}