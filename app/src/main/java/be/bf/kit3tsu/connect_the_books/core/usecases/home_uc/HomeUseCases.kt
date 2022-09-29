package be.bf.kit3tsu.connect_the_books.core.usecases.home_uc

import be.bf.kit3tsu.connect_the_books.core.usecases.shared.AddDirectory
import be.bf.kit3tsu.connect_the_books.core.usecases.shared.AddNote
import be.bf.kit3tsu.connect_the_books.core.usecases.shared.GetDirectories
import be.bf.kit3tsu.connect_the_books.core.usecases.shared.GetDirectory

data class HomeUseCases(
    val getBooks: GetBooks,
    val getBook: GetBook,
    val addBook: AddBook,
    val addDirectory: AddDirectory,
    val addNote: AddNote,
    val getDirectories: GetDirectories,
    val getDirectory: GetDirectory
) {
}