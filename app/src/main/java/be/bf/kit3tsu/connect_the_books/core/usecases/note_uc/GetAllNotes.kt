package be.bf.kit3tsu.connect_the_books.core.usecases.note_uc

import be.bf.kit3tsu.connect_the_books.core.repository.NoteRepository
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import kotlinx.coroutines.flow.Flow

//TODO delete this UseCase if never use
class GetAllNotes(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(): Flow<List<Note>> {
        return repository.getNotes()
    }
}