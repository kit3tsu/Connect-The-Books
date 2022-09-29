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
import be.bf.kit3tsu.connect_the_books.ui.destinations.EmptyDirectoryScreenDestination
import be.bf.kit3tsu.connect_the_books.ui.destinations.EmptyNoteScreenDestination
import be.bf.kit3tsu.connect_the_books.ui.destinations.DirectoryScreenDestination
import be.bf.kit3tsu.connect_the_books.ui.library.*
import be.bf.kit3tsu.connect_the_books.ui.theme.*
import coil.compose.rememberAsyncImagePainter
import be.bf.kit3tsu.connect_the_books.data.entities.Book
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@Destination(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    val onNewDirectory = action()
    val onNewNote = action()
    val onSearchBook = action()
    val directory = folders
    Surface(
        Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BookSearch({ onSearchBook })
            DirectoryCarousel(directory, navigator)
            BookCarousel(books, navigator)
            HomeButton(
                { onNewDirectory },
                { onNewNote },
                navigator
            )
            MyBottomAppBar()
        }
    }
}

@Composable
fun DirectoryCarousel(
    subDirectory: Array<Directory>,
    navigator: DestinationsNavigator
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        contentPadding = PaddingValues(all = 2.5.dp),
        modifier = Modifier.height(150.dp)
    ) {
        items(items = subDirectory) { item ->
            DirectoryItem(item = item, navigator)
        }
    }
}

@Composable
fun BookCarousel(
    books: Array<Book>,
    navigator: DestinationsNavigator
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        contentPadding = PaddingValues(all = 2.5.dp),
        modifier = Modifier.height(150.dp)
    ) {
        items(items = books) { item ->
            BookItem(navigator, item = item)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DirectoryItem(
    item: Directory,
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(all = 6.dp)
            .aspectRatio(1.25f, matchHeightConstraintsFirst = true)
            .clickable { navigator.navigate(DirectoryScreenDestination(item.directoryId)) },// TODO Add navigation
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 2.dp,

        ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = item.title, style = MaterialTheme.typography.h6)
            Divider(thickness = 2.dp, color = MaterialTheme.colors.onPrimary)

            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Nb Note = 12")
                Text(text = "Nb Note = 10")
                Text(text = "Nb Note = 3")
            }
        }
    }
}

@Composable
fun BookItem(
    navigator: DestinationsNavigator,
    item: Book,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .padding(all = 5.dp)
            .aspectRatio(0.8f, matchHeightConstraintsFirst = true)
            .height(150.dp)
            .clickable {
                navigator.navigate(DirectoryScreenDestination(item.directory))
            },// TODO Add navigation,
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
    onNewDirectory: () -> Unit,
    onNewNote: () -> Unit,
    navigator: DestinationsNavigator
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
            NewNoteButton(onNewNote, navigator)
            NewDirectoryButton(onNewDirectory, navigator)
        }
    }
}

@Composable
fun NewDirectoryButton(onNewDirectory: () -> Unit, navigator: DestinationsNavigator) {
    Button(
        onClick = { navigator.navigate(EmptyDirectoryScreenDestination) },
        modifier = Modifier,
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
        contentPadding = PaddingValues(8.dp),
    ) {
        ButtonText("Add New Folded")
    }
}

@Composable
fun NewNoteButton(onNewNote: () -> Unit, navigator: DestinationsNavigator) {
    Button(
        onClick = { navigator.navigate(EmptyNoteScreenDestination) },
        modifier = Modifier,
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
        contentPadding = PaddingValues(8.dp),
    ) {
        ButtonText("Add New Note")
    }
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
        //HomeScreen(directory = Directorys, onNewDirectory = { }, onNewNote = { }, {})
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
        //HomeScreen(directory = Directorys, onNewDirectory = { }, onNewNote = { }, {}, )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDirectoryItem() {
    ConnectTheBooksTheme {
        DirectoryItem(item = oneDirectory, navigator = EmptyDestinationsNavigator)
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun PreviewDarkDirectoryItem() {
    ConnectTheBooksTheme {
        DirectoryItem(item = oneDirectory, navigator = EmptyDestinationsNavigator)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBookItem() {
    ConnectTheBooksTheme {
        BookItem(item = oneBook, navigator = EmptyDestinationsNavigator)
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
        BookItem(item = oneBook, navigator = EmptyDestinationsNavigator)
    }
}