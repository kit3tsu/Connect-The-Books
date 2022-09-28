package be.bf.kit3tsu.connect_the_books.core.usecases.note_uc

import be.bf.kit3tsu.connect_the_books.core.repository.NoteRepository
import be.bf.kit3tsu.connect_the_books.data.entities.Note

class AddNote(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note){
        repository.insertNote(note)
    }
}