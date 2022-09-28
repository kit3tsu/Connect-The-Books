package be.bf.kit3tsu.connect_the_books.data.Repository

import be.bf.kit3tsu.connect_the_books.core.repository.NoteRepository
import be.bf.kit3tsu.connect_the_books.data.dao.NoteDao
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val dao : NoteDao) : NoteRepository {
    override suspend fun getNotes(): Flow<List<Note>> {
       return dao.findAll()
    }

    override suspend fun getNoteById(id: Int): Flow<Note> {
        return dao.findOneById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insert(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.delete(note)
    }
}