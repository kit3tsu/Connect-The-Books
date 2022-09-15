package be.bf.kit3tsu.connect_the_books.data.dao

import androidx.room.*
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySubDirectory
import be.bf.kit3tsu.connect_the_books.data.relations.NoteSTag
import com.example.tfe.data.entity.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao  {
    @Query("Select * from Note")
    fun findAll() : Flow<List<Note>>

    @Query("SELECT * FROM Note WHERE note_id = :id")
    fun findOneById(id: Int): Flow<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun  insert(value: Note )

    @Transaction
    @Query("SELECT * FROM Note")
    fun fingTags():Flow<List<NoteSTag>>

}
