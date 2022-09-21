package be.bf.kit3tsu.connect_the_books.ui.library.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.bf.kit3tsu.connect_the_books.R
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.ui.library.books
import be.bf.kit3tsu.connect_the_books.ui.library.folders
import coil.compose.rememberAsyncImagePainter
import com.example.tfe.data.entity.Book

@Composable
fun HomeScreen() {
    Surface(
        Modifier.fillMaxSize()
        // TODO Define here Personal and Material view design
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FolderCarousel()
            HomeButton()
            MyBottomAppBar()
        }
    }
}

@Composable
fun FolderCarousel() {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        contentPadding = PaddingValues(all = 2.5.dp),
        modifier = Modifier.height(150.dp)
    ) {
        items(items = books) { item ->
            BookItem(item) // FIXME
        }
    }
}

@Composable
fun FolderItem(
    item: Directory,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(all = 5.dp)
            .aspectRatio(1f, matchHeightConstraintsFirst = true),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = Color.Cyan,
        elevation = 2.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BookImage(// FIXME define the image dimension
                image = rememberAsyncImagePainter("https://edit.org/photos/images/cat/book-covers-big-2019101610.jpg-1300.jpg"),
                modifier = Modifier
                    .size(75.dp)
                    .weight(3f)
            )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = item.name)
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
            .aspectRatio(1f, matchHeightConstraintsFirst = true),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = Color.Cyan,
        elevation = 2.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BookImage(// FIXME define the image dimension
                image = rememberAsyncImagePainter("https://edit.org/photos/images/cat/book-covers-big-2019101610.jpg-1300.jpg"),
                modifier = Modifier
                    .size(75.dp)
                    .weight(3f)
            )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = item.title)
                Text(text = item.authors)
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
            .aspectRatio(1f)
            .padding(3.dp)
            .size(150.dp),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun MyBottomAppBar() {
    BottomAppBar() {

    }
}

@Composable
fun BookSearch() {
    //TODO("Not yet implemented")
}

@Composable
fun HomeButton() {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
    // TODO("Not yet implemented")
}

@Composable
fun NewNoteButton() {
//    TODO("Not yet implemented")
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