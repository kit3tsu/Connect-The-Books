package be.bf.kit3tsu.connect_the_books.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.bf.kit3tsu.connect_the_books.core.features.directory.DirectoryState
import be.bf.kit3tsu.connect_the_books.core.features.home.HomeState
import be.bf.kit3tsu.connect_the_books.core.usecases.home_uc.HomeUseCases
import be.bf.kit3tsu.connect_the_books.ui.library.books
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: HomeUseCases
) : ViewModel() {
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    private suspend fun getDirectories() {
        useCases.getDirectories()
            .onEach { directories ->
                _state.value = state.value.copy(directories = directories)
            }
            .launchIn(viewModelScope)
    }

    private suspend fun getBooks() {
        useCases.getBooks()
            .onEach { books ->
                _state.value = state.value.copy(books = books)
            }
            .launchIn(viewModelScope)
    }
}