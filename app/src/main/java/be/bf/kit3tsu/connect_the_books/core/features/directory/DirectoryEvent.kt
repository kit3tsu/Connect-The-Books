package be.bf.kit3tsu.connect_the_books.core.features.directory

import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.entities.Note

sealed class DirectoryEvent {
    object AddDirectory : DirectoryEvent()
    data class DeleteDirectory(val directory: Directory) : DirectoryEvent()
    //data class AddNote(val note: Note) : DirectoryEvent()
}