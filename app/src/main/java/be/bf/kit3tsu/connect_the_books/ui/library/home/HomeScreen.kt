package be.bf.kit3tsu.connect_the_books.ui.library.home

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.ui.library.books
import be.bf.kit3tsu.connect_the_books.ui.library.folders
import be.bf.kit3tsu.connect_the_books.ui.library.oneBook
import be.bf.kit3tsu.connect_the_books.ui.library.oneDirectory
import be.bf.kit3tsu.connect_the_books.ui.theme.AppButton
import be.bf.kit3tsu.connect_the_books.ui.theme.AppSearchBar
import be.bf.kit3tsu.connect_the_books.ui.theme.ConnectTheBooksTheme
import be.bf.kit3tsu.connect_the_books.ui.theme.MyBottomAppBar
import coil.compose.rememberAsyncImagePainter
import com.example.tfe.data.entity.Book
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination (start = true) //FIXME
@Composable
fun HomeScreen(
    directory: Array<Directory>,
    onNewFolder: () -> Unit,
    onNewNote: () -> Unit,
    onSearchBook: () -> Unit,
) {
    Surface(
        Modifier.fillMaxSize(),
        // TODO Define here Personal and Material view design
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BookSearch(onSearchBook)
            FolderCarousel(directory)
            BookCarousel(books)
            HomeButton(
                onNewFolder,
                onNewNote
            )
            MyBottomAppBar()
        }
    }
}

@Composable
fun FolderCarousel(
    subFolder: Array<Directory>
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        contentPadding = PaddingValues(all = 2.5.dp),
        modifier = Modifier.height(150.dp)
    ) {
        items(items = subFolder) { item ->
            FolderItem(item = item)
        }
    }
}

@Composable
fun BookCarousel(
    books: Array<Book>
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        contentPadding = PaddingValues(all = 2.5.dp),
        modifier = Modifier.height(150.dp)
    ) {
        items(items = books) { item ->
            BookItem(item = item)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FolderItem(
    item: Directory,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(all = 6.dp)
            .aspectRatio(1.25f, matchHeightConstraintsFirst = true)
            .clickable { },// TODO Add navigation
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 2.dp,

        ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = item.name, style = MaterialTheme.typography.h6)
            Divider(thickness = 2.dp, color = MaterialTheme.colors.onPrimary)

            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Nb Note = 12")
                Text(text = "Nb Note = 10")
                Text(text = "Nb Note = 3")
                Text(text = item.path)
            }
        }
    }
}

@Composable
fun BookItem(
    item: Book,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(all = 5.dp)
            .aspectRatio(0.8f, matchHeightConstraintsFirst = true)
            .height(150.dp)
            .clickable { },// TODO Add navigation,
        shape = MaterialTheme.shapes.large,
        backgroundColor = MaterialTheme.colors.primaryVariant,
        elevation = 2.dp
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BookImage(// FIXME define the image dimension
                image = rememberAsyncImagePainter("https://edit.org/photos/images/cat/book-covers-big-2019101610.jpg-1300.jpg"),
                modifier = Modifier
                    .size(75.dp)
                    .weight(3f)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = item.title, style = MaterialTheme.typography.caption)
                    Text(text = item.authors, style = MaterialTheme.typography.caption)
                }
            }
        }
    }
}

@Composable
fun BookImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier
            .aspectRatio(0.8f)
            .padding(0.dp)
            .size(100.dp)
            .border(BorderStroke(1.dp, color = MaterialTheme.colors.onPrimary)),
        contentScale = ContentScale.Fit
    )
}


@Composable
fun BookSearch(onSearchBook: () -> Unit) {
    val (text, onTextChange) = rememberSaveable { mutableStateOf("") }
    AppSearchBar(onSearchBook, text, onTextChange)
}


@Composable
fun HomeButton(
    onNewFolder: () -> Unit,
    onNewNote: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NewNoteButton(onNewNote)
            NewFolderButton(onNewFolder)
        }
    }
}

@Composable
fun NewFolderButton(onNewFolder: () -> Unit) {
    AppButton(onClickAction = {
//        navigator.navigate(
//
//    )
                              }, text = "Add New Folded")
}

@Composable
fun NewNoteButton(onNewNote: () -> Unit) {
    AppButton(onClickAction = onNewNote, text = "Add New Note")
}


//    BoxWithConstraints(
//        contentAlignment = Alignment.CenterStart,
//        modifier = modifier
//            .padding(start = 15.dp, end = 15.dp, bottom = 15.dp, top = 15.dp)
//            .clickable { } // TODO navigate to note detail
//            .clip(RoundedCornerShape(10.dp))
//            .background(color = Color.Cyan)
//            .aspectRatio(1f, matchHeightConstraintsFirst = true)
//            .size(height = 10.dp, width = 10.dp),
//    ) {
//        Text(text = item.name, modifier = Modifier.align(Alignment.TopStart))
//        Text(text = item.path,Modifier.align(Alignment.CenterStart))
//    }

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    ConnectTheBooksTheme {
        //HomeScreen(directory = folders, onNewFolder = { }, onNewNote = { }, {})
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun PreviewDarkHomeScreen() {
    ConnectTheBooksTheme {
        //HomeScreen(directory = folders, onNewFolder = { }, onNewNote = { }, {}, )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFolderItem() {
    ConnectTheBooksTheme {
        FolderItem(item = oneDirectory)
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun PreviewDarkFolderItem() {
    ConnectTheBooksTheme {
        FolderItem(item = oneDirectory)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBookItem() {
    ConnectTheBooksTheme {
        BookItem(item = oneBook)
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun PreviewDarkBookItem() {
    ConnectTheBooksTheme {
        BookItem(item = oneBook)
    }
}