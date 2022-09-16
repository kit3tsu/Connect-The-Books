package be.bf.kit3tsu.connect_the_books.ui.library.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Surface(
        Modifier.fillMaxSize()
        // TODO Define here Personal and Material view design
    ) {
        Column() {
            FolderCarousel()
            HomeButton()
            MyBottomAppBar()
        }
    }
}

@Composable
fun FolderCarousel() {
    TODO("Not yet implemented")
}

@Composable
fun MyBottomAppBar() {
    BottomAppBar() {

    }
}

@Composable
fun BookSearch() {
    TODO("Not yet implemented")
}

@Composable
fun HomeButton() {
    Column {
        Row(
            Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NewNoteButton()
            NewFolderButton()
        }
        BookSearch()

    }
}

@Composable
fun NewFolderButton() {
    TODO("Not yet implemented")
}

@Composable
fun NewNoteButton() {
    TODO("Not yet implemented")
}
