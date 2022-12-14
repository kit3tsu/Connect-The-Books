package be.bf.kit3tsu.connect_the_books.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.bf.kit3tsu.connect_the_books.core.features.home.HomeEvent
import be.bf.kit3tsu.connect_the_books.core.features.home.HomeState
import be.bf.kit3tsu.connect_the_books.core.usecases.home_uc.HomeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: HomeUseCases
) : ViewModel() {
    private val _books = mutableStateOf(HomeState.BookHomeState())
    val books: State<HomeState.BookHomeState> = _books

    private val _subDirectories = mutableStateOf(HomeState.SubDirectoryHomeState())
    val subDirectories: State<HomeState.SubDirectoryHomeState> = _subDirectories
   // private var getNotesJob: Job? = null
    private val _search = mutableStateOf(
        HomeState.SearchBarHomeState(
            hint = "Enter ISBN",
        )
    )
    val search: State<HomeState.SearchBarHomeState> = _search

    init {
        getSubDirectories()
        getBooks()
        Log.d("HomeVM", subDirectories.value.subDirectory.toString())
    }

    private fun getSubDirectories() {
        viewModelScope.launch {
            useCases.getRootRepository()
                .onEach { directory ->
                    _subDirectories.value = subDirectories.value.copy(subDirectory = directory)
                    Log.d("HomeVM", "getSubDirectories: " + subDirectories.value.subDirectory.toString())
                }
        }
    }

    private fun getBooks() {
        //getNotesJob?.cancel()getNotesJob =
        viewModelScope.launch {
            useCases.getBooks()
                .onEach { book ->
                    _books.value = books.value.copy(books = book)
                }.launchIn(viewModelScope)
        }

    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.EnterIsbn -> {
                _search.value = search.value.copy(text = event.value)
            }
            is HomeEvent.ChangeIsbnFocus -> {
                _search.value =
                    search.value.copy(isHintVisible = !event.focusState.isFocused && search.value.text.isBlank())
            }
        }
    }
}