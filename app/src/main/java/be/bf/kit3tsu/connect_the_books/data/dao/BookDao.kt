package be.bf.kit3tsu.connect_the_books.data.dao

import androidx.room.Dao
import androidx.room.Query
import be.bf.kit3tsu.connect_the_books.data.entities.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao : BaseDao<Book> {

    @Query("SELECT * FROM Book")
    fun getAllBook(): Flow<List<Book>>

    @Query("SELECT * FROM Book WHERE book_id = :id")
    fun getBookById(id: Int): Flow<Book>

}