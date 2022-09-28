package be.bf.kit3tsu.connect_the_books.data.Repository

import be.bf.kit3tsu.connect_the_books.data.entities.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Flow<Note>

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
    
}