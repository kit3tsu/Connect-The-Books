package be.bf.kit3tsu.connect_the_books.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.bf.kit3tsu.connect_the_books.core.features.directory.DirectoryEvent
import be.bf.kit3tsu.connect_the_books.core.features.directory.DirectoryState
import be.bf.kit3tsu.connect_the_books.core.usecases.directory_uc.DirectoryUseCases
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.util.Visibility
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DirectoryViewModel @Inject constructor(
    private val useCases: DirectoryUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var currentDirectoryId: Int = -1
    private var currentDirectoryParent: Int? = null
    private var currentDirectoryTitle: String = ""
    private var currentDirectoryVisibility: Visibility = Visibility.PUBLIC

    init {
        savedStateHandle.get<Int>("directoryId")?.let { directoryId ->
            {
                if (directoryId != -1) {
                    viewModelScope.launch {
                        useCases.getDirectory(directoryId).collect() { directory ->
                            currentDirectoryId = directory.directoryId
                            currentDirectoryParent = directory.parentDirectory
                            currentDirectoryTitle = directory.name
                            currentDirectoryVisibility = directory.visibility
                        }
                    }
                }
            }
        }
    }

    private val _state = mutableStateOf(DirectoryState())
    val state: State<DirectoryState> = _state

    fun onEvent(event: DirectoryEvent) {
        when (event) {
            is DirectoryEvent.DeleteDirectory -> {
                viewModelScope.launch {
                    useCases.deleteDirectory(event.directory)
                }
            }
            is DirectoryEvent.AddDirectory -> {
                viewModelScope.launch {
                    useCases.addDirectory(
                        Directory(
                            directoryId = currentDirectoryId,
                            name = currentDirectoryTitle,
                            path = "",
                            imgSrc = "",
                            visibility = currentDirectoryVisibility,
                            parentDirectory = currentDirectoryParent
                        )
                    )
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
            useCases.getSubDirectories()
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
}