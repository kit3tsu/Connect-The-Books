package be.bf.kit3tsu.connect_the_books.core.features.home

import be.bf.kit3tsu.connect_the_books.data.entities.Book
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySubDirectory


//data class HomeState(
//    val books: List<Book> = emptyList(),
//    val subDirectory: List<DirectorySubDirectory> = emptyList(),
//    val text:String = "",
//    val hint:String = "",
//    val isHintVisible : Boolean = true
//)

sealed class HomeState {
    data class BookHomeState(val books: List<Book> = emptyList() ) : HomeState()
    data class SubDirectoryHomeState( val subDirectory: List<DirectorySubDirectory> = emptyList() ) : HomeState()
    data class SearchBarHomeState(    val text:String = "",
                                      val hint:String = "",
                                      val isHintVisible : Boolean = true ) : HomeState()
}