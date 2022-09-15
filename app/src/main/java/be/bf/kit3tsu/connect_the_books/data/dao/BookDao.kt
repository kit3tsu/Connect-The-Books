package be.bf.kit3tsu.connect_the_books.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tfe.data.entity.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao  {

    @Query("SELECT * FROM Book")
    fun findAll(): Flow<List<Book>>

    @Query("SELECT * FROM Book WHERE book_id = :id")
    fun findOneById(id: Int): Flow<Book>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun  insert(value: Book)
}