package be.bf.kit3tsu.connect_the_books.ui.library.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.ui.library.folders

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
    LazyHorizontalGrid(rows = GridCells.Fixed(1), contentPadding = PaddingValues(all = 2.5.dp),modifier = Modifier.height(200.dp)) {
        items(items = folders) { item ->
            FolderItem(item ) // FIXME
        }
    }
}

@Composable
fun FolderItem(
    item: Directory,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        contentAlignment = Alignment.CenterStart,
        modifier = modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 15.dp, top = 15.dp)
            .clickable { } // TODO navigate to note detail
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.Cyan)
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .size(height = 10.dp, width = 10.dp),
    ) {
        Text(text = item.name, modifier = Modifier.align(Alignment.TopStart))
        Text(text = item.path,Modifier.align(Alignment.CenterStart))
    }
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
    TODO("Not yet implemented")
}

@Composable
fun NewNoteButton() {
    TODO("Not yet implemented")
}
