package be.bf.kit3tsu.connect_the_books.core.repository

import be.bf.kit3tsu.connect_the_books.data.entities.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {

    suspend fun getBooks(): Flow<List<Book>>

    suspend fun getBookById(id: Int): Flow<Book>

    suspend fun insertBook(book: Book)

    suspend fun deleteBook(book: Book)
}