package be.bf.kit3tsu.connect_the_books.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.bf.kit3tsu.connect_the_books.core.features.directory.DirectoryEvent
import be.bf.kit3tsu.connect_the_books.core.features.directory.DirectoryState
import be.bf.kit3tsu.connect_the_books.core.usecases.directory_uc.DirectoryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FolderViewModel @Inject constructor(
    private val useCases: DirectoryUseCases
) : ViewModel(){
    private val _state = mutableStateOf(DirectoryState())
    val state : State<DirectoryState> = _state

    fun onEvent(event: DirectoryEvent){
        when(event){
            is DirectoryEvent.DeleteDirectory -> {
                viewModelScope.launch {
                    useCases.deleteDirectory(event.directory)
                }
            }
        }
    }

    private suspend fun getNotes(){
        useCases.getNotes()
            .onEach { notes ->
                _state.value = state.value.copy(notes = notes)
            }
            .launchIn(viewModelScope)
    }
    private suspend fun getDirectories(){
        useCases.getDirectories()
            .onEach { directories ->
                _state.value = state.value.copy(directories = directories)
            }
            .launchIn(viewModelScope)
    }
}