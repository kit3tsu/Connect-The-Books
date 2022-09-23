package be.bf.kit3tsu.connect_the_books.ui.library.directory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
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
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.ui.library.folders
import be.bf.kit3tsu.connect_the_books.ui.library.home.FolderCarousel
import be.bf.kit3tsu.connect_the_books.ui.library.notes
import be.bf.kit3tsu.connect_the_books.ui.library.oneNote
import be.bf.kit3tsu.connect_the_books.ui.theme.AppTheme
import be.bf.kit3tsu.connect_the_books.ui.theme.ConnectTheBooksTheme

@Composable
fun FolderScreen(
    noteList: Array<Note>,
    subFolder: Array<Directory>
) {
    Surface() {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            FolderCarousel(subFolder)
            LazyColumn(
                contentPadding = PaddingValues(start = 8.dp,end = 8.dp),
                 modifier = Modifier.height(360.dp)) {
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
            .clip(CutCornerShape(topStart = 12.dp))
            .background(color = MaterialTheme.colors.primaryVariant)
            .fillMaxWidth(0.9f)
    ){
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            Text(text = note.name, style = MaterialTheme.typography.subtitle1)
            Text(text = note.description, style = MaterialTheme.typography.body2)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotePreviewPreview() {
    ConnectTheBooksTheme() {
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
            FolderScreen(notes, folders)
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
