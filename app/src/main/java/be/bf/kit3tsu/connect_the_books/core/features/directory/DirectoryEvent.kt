package be.bf.kit3tsu.connect_the_books.core.features.directory

import androidx.compose.ui.focus.FocusState
import be.bf.kit3tsu.connect_the_books.core.features.note.NoteEvent
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.entities.Note

sealed class DirectoryEvent {
    object AddDirectory : DirectoryEvent()
    object DeleteDirectory : DirectoryEvent()
    data class EnterTitle(val value: String) : DirectoryEvent()
    data class ChangeTitleFocus(val focusState: FocusState) : DirectoryEvent()
    //data class AddNote(val note: Note) : DirectoryEvent()
}