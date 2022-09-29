package be.bf.kit3tsu.connect_the_books.core.features.home

import androidx.compose.ui.focus.FocusState

sealed class HomeEvent {
    //TODO search book event
    data class EnterIsbn(val value: String) : HomeEvent()
    data class ChangeIsbnFocus(val focusState: FocusState) : HomeEvent()
}