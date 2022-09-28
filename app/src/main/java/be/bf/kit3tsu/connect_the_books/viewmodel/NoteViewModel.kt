package be.bf.kit3tsu.connect_the_books.viewmodel

import androidx.lifecycle.ViewModel
import be.bf.kit3tsu.connect_the_books.core.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
) :ViewModel() {

    //TODO manage state

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()
}

sealed class UiEvent {
    data class ShowSnackbar(val message : String):UiEvent()
    object SaveNote : UiEvent()
}
