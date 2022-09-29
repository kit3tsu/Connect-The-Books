package be.bf.kit3tsu.connect_the_books.core.usecases.shared

import be.bf.kit3tsu.connect_the_books.core.repository.NoteRepository
import be.bf.kit3tsu.connect_the_books.data.entities.Note

class AddNote(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        //TODO validate data before insert
        repository.insertNote(note)
    }
}