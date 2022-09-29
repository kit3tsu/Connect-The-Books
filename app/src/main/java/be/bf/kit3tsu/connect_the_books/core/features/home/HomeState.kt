package be.bf.kit3tsu.connect_the_books.core.features.home

import be.bf.kit3tsu.connect_the_books.data.entities.Book
import be.bf.kit3tsu.connect_the_books.data.entities.Directory


data class HomeState(
    val books: List<Book> = emptyList(),
    val directories: List<Directory> = emptyList()
)