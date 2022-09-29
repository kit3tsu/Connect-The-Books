package be.bf.kit3tsu.connect_the_books.core.features.directory

import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySNote
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySubDirectory

data class DirectoryState(
    val notes: List<DirectorySNote> = emptyList(),
    val subDirectory: List<DirectorySubDirectory> = emptyList(),
    val text:String = "",
    val hint:String = "",
    val isHintVisible : Boolean = true
)
