package be.bf.kit3tsu.connect_the_books.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.bf.kit3tsu.connect_the_books.core.features.directory.DirectoryEvent
import be.bf.kit3tsu.connect_the_books.core.features.directory.DirectoryState
import be.bf.kit3tsu.connect_the_books.core.features.note.NoteEvent
import be.bf.kit3tsu.connect_the_books.core.features.note.NoteState
import be.bf.kit3tsu.connect_the_books.core.usecases.directory_uc.DirectoryUseCases
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.util.Visibility
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DirectoryViewModel @Inject constructor(
    private val useCases: DirectoryUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var currentDirectoryId: Int? = null
    private var currentDirectoryParent: Int? = null
    private var currentDirectoryVisibility: Visibility = Visibility.PUBLIC

    private val _eventFlow = MutableSharedFlow<DirectoryViewModel.UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        savedStateHandle.get<Int>("directoryId")?.let { directoryId ->
            {
                if (directoryId != -1) {
                    viewModelScope.launch {
                        useCases.getDirectory(directoryId).collect() { directory ->
                            currentDirectoryId = directory.directoryId
                            currentDirectoryParent = directory.parentDirectory
                            _directoryTitle.value = directoryTitle.value.copy(text = directory.title)
                            currentDirectoryVisibility = directory.visibility
                        }
                    }
                }
            }
        }
    }

    private val _state = mutableStateOf(DirectoryState())
    val state: State<DirectoryState> = _state

    private val _directoryTitle = mutableStateOf(
        DirectoryState(
            hint = "Enter the title .."
        )
    )
    val directoryTitle: State<DirectoryState> = _directoryTitle
    private val _directoryContent = mutableStateOf(
        DirectoryState(
            hint = "Start your directory ..."
        )
    )

    init {
        getDirectories()
        getNotes()
    }

    fun onEvent(event: DirectoryEvent) {
        when (event) {
            is DirectoryEvent.EnterTitle -> {
                _directoryTitle.value = directoryTitle.value.copy(text = event.value)
            }
            is DirectoryEvent.ChangeTitleFocus -> {
                _directoryTitle.value =
                    directoryTitle.value.copy(isHintVisible = !event.focusState.isFocused && directoryTitle.value.text.isBlank())
            }
            is DirectoryEvent.DeleteDirectory -> {
                viewModelScope.launch {
                    useCases.deleteDirectory(
                        Directory(
                            directoryId = currentDirectoryId,
                            title = _directoryTitle.value.text,
                            visibility = currentDirectoryVisibility,
                            parentDirectory = currentDirectoryParent
                        )
                    )
                    _eventFlow.emit(UiEvent.DeleteDirectory)
                }
            }
            is DirectoryEvent.AddDirectory -> {
                viewModelScope.launch {
                    useCases.addDirectory(
                        Directory(
                            directoryId = currentDirectoryId,
                            title = _directoryTitle.value.text,
                            visibility = currentDirectoryVisibility,
                            parentDirectory = currentDirectoryParent
                        )
                    )
                    _eventFlow.emit(UiEvent.SaveDirectory)
                }
            }
        }
    }

    private fun getNotes() {
        viewModelScope.launch {
            useCases.getNotes()
                .onEach { notes ->
                    _state.value = state.value.copy(notes = notes)
                }
        }
    }

    private fun getDirectories() {
        viewModelScope.launch {
            useCases.getSubDirectories(currentDirectoryParent)
                .collect { subDirectory ->
                    _state.value = state.value.copy(subDirectory = subDirectory)
                }
        }
    }
    //    private fun getDirectories() {
//         useCases.getSubDirectories().onEach {  subDirectory ->
//             _state.value = state.value.copy(subDirectory = subDirectory)
//         }.launchIn(viewModelScope) }
//
//    }
    sealed class UiEvent {
        object SaveDirectory : UiEvent()
        object DeleteDirectory : UiEvent()
    }
}