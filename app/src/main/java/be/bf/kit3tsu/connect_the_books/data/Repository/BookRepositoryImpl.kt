package be.bf.kit3tsu.connect_the_books.data.Repository

import be.bf.kit3tsu.connect_the_books.core.repository.BookRepository
import be.bf.kit3tsu.connect_the_books.data.dao.BookDao
import be.bf.kit3tsu.connect_the_books.data.entities.Book
import kotlinx.coroutines.flow.Flow

class BookRepositoryImpl(private val dao: BookDao):BookRepository {
    override suspend fun getBooks(): Flow<List<Book>> {
        return dao.findAll()
    }

    override suspend fun getBookById(id: Int): Flow<Book> {
        return dao.findOneById(id)
    }

    override suspend fun insertBook(book: Book) {
        dao.insert(book)
    }

    override suspend fun deleteBook(book: Book) {
        dao.delete(book)
    }
}