package be.bf.kit3tsu.connect_the_books.viewmodel

import androidx.lifecycle.ViewModel
import be.bf.kit3tsu.connect_the_books.core.usecases.directory_uc.DirectoryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FolderViewModel @Inject constructor(
    private val useCases: DirectoryUseCases
) : ViewModel(){
}