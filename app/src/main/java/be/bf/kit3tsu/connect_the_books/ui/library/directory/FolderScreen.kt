package be.bf.kit3tsu.connect_the_books.ui.library.directory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.bf.kit3tsu.connect_the_books.ComplexExampleContent
import be.bf.kit3tsu.connect_the_books.Greeting
import be.bf.kit3tsu.connect_the_books.MinimalExampleContent
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.ui.library.home.FolderCarousel
import be.bf.kit3tsu.connect_the_books.ui.library.home.MyBottomAppBar
import be.bf.kit3tsu.connect_the_books.ui.library.notes
import be.bf.kit3tsu.connect_the_books.ui.library.oneNote
import be.bf.kit3tsu.connect_the_books.ui.theme.ConnectTheBooksTheme

@Composable
fun FolderScreen(noteList: Array<Note>) {
    Surface() {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            FolderCarousel()
            LazyColumn(
                contentPadding = PaddingValues(start = 8.dp,end = 8.dp, bottom = 75.dp),
                 modifier = Modifier.height(400.dp)) {
                items(items = noteList) { note ->
                    NotePreview(note = note)
                }
            }
            BottomAppBar() {

            }
        }
    }
}
// contentPadding = PaddingValues(start = 8.dp,end = 8.dp, bottom = 75.dp)
@Composable
fun NotePreview(note: Note) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
            .clickable { } // TODO navigate to note detail
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.Cyan)
            .fillMaxWidth(0.9f),

    ){
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = note.name)
            Text(text = note.description)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotePreviewPreview() {
    ConnectTheBooksTheme {
        Column() {
            NotePreview(oneNote)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FolderScreenPreview() {
    ConnectTheBooksTheme {
        Column() {
            FolderScreen(notes)
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
