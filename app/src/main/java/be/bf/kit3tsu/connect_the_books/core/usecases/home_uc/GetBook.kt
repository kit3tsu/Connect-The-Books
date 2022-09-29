package be.bf.kit3tsu.connect_the_books.core.usecases.home_uc

import be.bf.kit3tsu.connect_the_books.core.repository.BookRepository
import be.bf.kit3tsu.connect_the_books.data.entities.Book
import kotlinx.coroutines.flow.Flow

class GetBook(private val repository: BookRepository) {
    suspend operator fun invoke(id:Int): Flow<Book> {
        return repository.getBookById(id)
    }
}