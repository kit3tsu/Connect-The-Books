package be.bf.kit3tsu.connect_the_books.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.bf.kit3tsu.connect_the_books.core.features.directory.DirectoryEvent
import be.bf.kit3tsu.connect_the_books.core.features.note.NoteEvent
import be.bf.kit3tsu.connect_the_books.core.features.note.NoteState
import be.bf.kit3tsu.connect_the_books.core.repository.NoteRepository
import be.bf.kit3tsu.connect_the_books.core.usecases.note_uc.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val useCases: NoteUseCases
) :ViewModel() {
   private val _state = mutableStateOf(NoteState())
    val state : State<NoteState> = _state
    //TODO manage state

    fun onEvent(event: NoteEvent){
        when(event){
            is NoteEvent.AddNote -> {
                viewModelScope.launch {
                    useCases.addNote(event.note)
                }
            }
            is NoteEvent.DeleteNote ->{
                viewModelScope.launch {
                    useCases.deleteNote(event.note)
                }
            }
        }
    }

//    private fun getNote(){
//        useCases.getNote() ->
//    }

//    private val _eventFlow = MutableSharedFlow<UiEvent>()
//    val eventFlow = _eventFlow.asSharedFlow()
}

sealed class UiEvent {
    data class ShowSnackbar(val message : String):UiEvent()
    object SaveNote : UiEvent()
}
