package be.bf.kit3tsu.connect_the_books.core.usecases.home_uc

import be.bf.kit3tsu.connect_the_books.core.usecases.shared.*

data class HomeUseCases(
    val getBooks: GetBooks,
    val getBook: GetBook,
    val addBook: AddBook,
    val addDirectory: AddDirectory,
    val addNote: AddNote,
    val getSubDirectories: GetSubDirectories,
    val getDirectory: GetDirectory,
    val getRootRepository: GetRootRepository
) {
}