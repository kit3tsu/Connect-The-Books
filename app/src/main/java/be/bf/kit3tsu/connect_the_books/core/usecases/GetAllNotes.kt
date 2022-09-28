package be.bf.kit3tsu.connect_the_books.core.usecases

import be.bf.kit3tsu.connect_the_books.core.repository.NoteRepository
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import kotlinx.coroutines.flow.Flow

class GetAllNotes(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(): Flow<List<Note>> {
        return repository.getNotes()
    }
}