package be.bf.kit3tsu.connect_the_books.ui.library.directory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.ui.destinations.NoteScreenDestination
import be.bf.kit3tsu.connect_the_books.ui.library.*
import be.bf.kit3tsu.connect_the_books.ui.library.home.DirectoryCarousel
import be.bf.kit3tsu.connect_the_books.ui.theme.ConnectTheBooksTheme
import be.bf.kit3tsu.connect_the_books.viewmodel.NoteViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator


@Destination
@Composable
fun DirectoryScreen(
    directoryId: Int,
    navigator: DestinationsNavigator
) {
    val noteList = getNotesList(directoryId)
    val subDirectory = getSubFoldersList(directoryId)
    Surface() {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            DirectoryCarousel(subDirectory, navigator)
            LazyColumn(
                contentPadding = PaddingValues(start = 8.dp, end = 8.dp),
                modifier = Modifier.height(360.dp)
            ) {
                items(items = noteList) { note ->
                    NotePreview(note = note, navigator)
                }
            }
            BottomAppBar() {

            }
        }
    }
}

@Destination
@Composable
fun EmptyDirectoryScreen(
    navigator: DestinationsNavigator
) {
    Surface() {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(text = "Empty Directory")
        }
    }
}

// contentPadding = PaddingValues(start = 8.dp,end = 8.dp, bottom = 75.dp)
@Composable
fun NotePreview(note: Note, navigator: DestinationsNavigator) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
            .clickable {
                navigator.navigate(NoteScreenDestination()) }
            .clip(CutCornerShape(topStart = 12.dp))
            .background(color = MaterialTheme.colors.primaryVariant)
            .fillMaxWidth(0.9f)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            Text(text = note.title, style = MaterialTheme.typography.subtitle1)
            //Text(text = note.description, style = MaterialTheme.typography.body2)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotePreviewPreview() {
    ConnectTheBooksTheme() {
        Column() {
            NotePreview(oneNote, navigator = EmptyDestinationsNavigator)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DirectoryScreenPreview() {
    ConnectTheBooksTheme {
        Column() {
            DirectoryScreen(1, navigator = EmptyDestinationsNavigator)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Preview() {
//    ConnectTheBooksTheme {
//        Column() {
//
//        }
//    }
//}
