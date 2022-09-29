package be.bf.kit3tsu.connect_the_books.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.bf.kit3tsu.connect_the_books.core.features.note.NoteEvent
import be.bf.kit3tsu.connect_the_books.core.features.note.NoteState
import be.bf.kit3tsu.connect_the_books.core.usecases.note_uc.NoteUseCases
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.data.util.Visibility
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val useCases: NoteUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var currentNoteId: Int? = null
    private var currentNoteDirectory: Int = 0
    private var currentNoteVisibility: Visibility = Visibility.PUBLIC

    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            if (noteId != -1) {
                viewModelScope.launch {
                    useCases.getNote(noteId).collect() { note ->
                        currentNoteId = note.noteId
                        currentNoteDirectory = note.parentDirectory
                        currentNoteVisibility = note.visibility
                        _noteTitle.value = noteTitle.value.copy(text = note.title)
                        _noteContent.value = noteContent.value.copy(isHintVisible = false)
                    }
                }
            }
        }
    }

    private val _noteTitle = mutableStateOf(
        NoteState(
            hint = "Enter the title .."
        )
    )
    val noteTitle: State<NoteState> = _noteTitle
    private val _noteContent = mutableStateOf(
        NoteState(
            hint = "Start your note ..."
        )
    )
    val noteContent: State<NoteState> = _noteContent

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: NoteEvent) {
        when (event) {
            is NoteEvent.EnterTitle -> {
                _noteTitle.value = noteTitle.value.copy(text = event.value)
            }
            is NoteEvent.ChangeTitleFocus -> {
                _noteTitle.value =
                    noteTitle.value.copy(isHintVisible = !event.focusState.isFocused && noteTitle.value.text.isBlank())
            }
            is NoteEvent.ChangeContentFocus -> {
                _noteContent.value =
                    noteContent.value.copy(isHintVisible = !event.focusState.isFocused && noteContent.value.text.isBlank())
            }
            is NoteEvent.EnterContent -> {
                _noteContent.value = noteContent.value.copy(text = event.value)
            }
            is NoteEvent.AddNote -> {
                viewModelScope.launch {
                    useCases.addNote(
                        Note(
                            noteId = currentNoteId,
                            title = _noteTitle.value.text,
                            content = _noteContent.value.text,
                            visibility = currentNoteVisibility,
                            parentDirectory = currentNoteDirectory
                            //TODO change default value
                        )
                    )
                    _eventFlow.emit(UiEvent.SaveNote)
                }
            }
            is NoteEvent.DeleteNote -> {
                viewModelScope.launch {
                    useCases.deleteNote(
                        Note(
                            noteId = currentNoteId,
                            title = _noteTitle.value.text,
                            content = _noteContent.value.text,
                            visibility = currentNoteVisibility,
                            parentDirectory = currentNoteDirectory
                            //TODO change default value
                        )
                    )
                    _eventFlow.emit(UiEvent.DeleteNote)
                }
            }
        }
    }

    sealed class UiEvent {
        object SaveNote : UiEvent()
        object DeleteNote : UiEvent()
    }
}


