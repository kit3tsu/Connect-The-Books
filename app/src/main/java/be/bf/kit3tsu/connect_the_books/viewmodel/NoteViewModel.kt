package be.bf.kit3tsu.connect_the_books.viewmodel

import androidx.lifecycle.ViewModel
import be.bf.kit3tsu.connect_the_books.data.Repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
) :ViewModel() {

    //TODO manage state

    //val notes = repository.getNotes()

}