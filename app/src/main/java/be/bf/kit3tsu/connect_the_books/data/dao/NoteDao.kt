package be.bf.kit3tsu.connect_the_books.data.dao

import androidx.room.*
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.data.relations.NoteSTag
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao : BaseDao<Note> {
    @Query("Select * from Note")
    fun findAll(): Flow<List<Note>>

    @Query("SELECT * FROM Note WHERE note_id = :id")
    fun findOneById(id: Int): Flow<Note>

    @Transaction
    @Query("SELECT * FROM Note")
    fun findTags(): Flow<List<NoteSTag>>

}
