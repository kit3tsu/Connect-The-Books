package be.bf.kit3tsu.connect_the_books.ui.library.directory

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import be.bf.kit3tsu.connect_the_books.core.features.directory.DirectoryEvent
import be.bf.kit3tsu.connect_the_books.core.features.note.NoteEvent
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.ui.TransparentHintTextField
import be.bf.kit3tsu.connect_the_books.ui.destinations.DirectoryScreenDestination
import be.bf.kit3tsu.connect_the_books.ui.destinations.NoteScreenDestination
import be.bf.kit3tsu.connect_the_books.ui.library.*
import be.bf.kit3tsu.connect_the_books.ui.library.home.DirectoryCarousel
import be.bf.kit3tsu.connect_the_books.ui.theme.ConnectTheBooksTheme
import be.bf.kit3tsu.connect_the_books.viewmodel.DirectoryViewModel
import be.bf.kit3tsu.connect_the_books.viewmodel.NoteViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import kotlinx.coroutines.flow.collectLatest


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun DirectoryScreen(
    directoryId: Int,
    navigator: DestinationsNavigator,
    viewModel: DirectoryViewModel = hiltViewModel()
) {
    val notesState = viewModel.state.value.notes.get(0).notes
    val subDirectoryState = viewModel.state.value.subDirectory.get(0).subDirectory
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is DirectoryViewModel.UiEvent.SaveDirectory -> {
                    navigator.navigate(DirectoryScreenDestination(-1))
                }
                is DirectoryViewModel.UiEvent.DeleteDirectory -> {
                    navigator.navigateUp()
                }
            }
        }
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(DirectoryEvent.DeleteDirectory)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "AddDirectory")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            DirectoryCarousel(subDirectoryState, navigator)
            LazyColumn(
                contentPadding = PaddingValues(start = 8.dp, end = 8.dp),
                modifier = Modifier.height(360.dp)
            ) {
                items(items = notesState) { note ->
                    NotePreview(note = note, navigator)
                }
            }
            BottomAppBar() {

            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun EmptyDirectoryScreen(
    navigator: DestinationsNavigator,
    viewModel: DirectoryViewModel = hiltViewModel()
) {
    val titleState = viewModel.directoryTitle.value
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is DirectoryViewModel.UiEvent.SaveDirectory -> {
                    navigator.navigate(DirectoryScreenDestination(-1))
                }
                is DirectoryViewModel.UiEvent.DeleteDirectory -> {
                    navigator.navigateUp()
                }
            }
        }
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(DirectoryEvent.AddDirectory)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Done, contentDescription = "AddDirectory")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TransparentHintTextField(
                text = titleState.text,
                hint = titleState.hint,
                onValueChange = {
                    viewModel.onEvent(DirectoryEvent.EnterTitle(it))
                },
                onFocusChange = {
                    viewModel.onEvent(DirectoryEvent.ChangeTitleFocus(it))
                },
                isHintVisible = titleState.isHintVisible,
                singleLine = true,
                textStyle = MaterialTheme.typography.h5
            )
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
                navigator.navigate(NoteScreenDestination())
            }
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
