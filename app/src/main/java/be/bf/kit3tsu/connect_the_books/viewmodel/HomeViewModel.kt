package be.bf.kit3tsu.connect_the_books.viewmodel

import androidx.lifecycle.ViewModel
import be.bf.kit3tsu.connect_the_books.core.usecases.home_uc.HomeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: HomeUseCases
) : ViewModel() {
}