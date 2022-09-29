package be.bf.kit3tsu.connect_the_books.core.usecases.home_uc

import be.bf.kit3tsu.connect_the_books.core.repository.BookRepository
import be.bf.kit3tsu.connect_the_books.data.entities.Book

class AddBook(private val repository: BookRepository) {
    suspend operator fun invoke(book:Book){
        //TODO validate data before insert
        repository.insertBook(book)
    }
}