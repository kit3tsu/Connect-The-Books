package be.bf.kit3tsu.connect_the_books.core.usecases

import be.bf.kit3tsu.connect_the_books.core.repository.NoteRepository
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import kotlinx.coroutines.flow.Flow

class GetNote (
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Flow<Note> {
        return repository.getNoteById(id)
    }
}