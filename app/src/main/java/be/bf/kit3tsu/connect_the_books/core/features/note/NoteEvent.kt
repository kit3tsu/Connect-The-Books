package be.bf.kit3tsu.connect_the_books.core.features.note

import androidx.compose.ui.focus.FocusState
import be.bf.kit3tsu.connect_the_books.core.features.directory.DirectoryEvent
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.entities.Note

sealed class NoteEvent {
    object AddNote : NoteEvent()
    object DeleteNote : NoteEvent()
    data class EnterTitle(val value: String) : NoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState) : NoteEvent()
    data class EnterContent(val value: String) : NoteEvent()
    data class ChangeContentFocus(val focusState: FocusState) : NoteEvent()
}