package be.bf.kit3tsu.connect_the_books.ui.library.directory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.ui.library.home.FolderCarousel
import be.bf.kit3tsu.connect_the_books.ui.library.home.MyBottomAppBar
import be.bf.kit3tsu.connect_the_books.ui.library.notes

@Composable
fun FolderScreen() {
    Surface() {
        Column {
            FolderCarousel()
            LazyColumn() {
                items(items = notes) { note ->
                    NotePreview(note = note)
                }

            }
            MyBottomAppBar()
        }
    }
}

@Composable
fun NotePreview(note: Note) {
    TODO("Not yet implemented")
}
