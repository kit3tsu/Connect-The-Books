package be.bf.kit3tsu.connect_the_books.ui.note

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import be.bf.kit3tsu.connect_the_books.core.features.note.NoteEvent
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.ui.TransparentHintTextField
import be.bf.kit3tsu.connect_the_books.viewmodel.NoteViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun NoteScreen(navigator: DestinationsNavigator, viewModel: NoteViewModel = hiltViewModel()) {
    val titleState = viewModel.noteTitle.value
    val contentState = viewModel.noteContent.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope() // for animation

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is NoteViewModel.UiEvent.SaveNote -> {
                    navigator.navigateUp()
                }
                is NoteViewModel.UiEvent.DeleteNote -> {
                    navigator.navigateUp()
                }
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(NoteEvent.AddNote)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Done, contentDescription = "SaveNote")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Surface() {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                TransparentHintTextField(
                    text = titleState.text,
                    hint = titleState.hint,
                    onValueChange = {
                        viewModel.onEvent(NoteEvent.EnterTitle(it))
                    },
                    onFocusChange = {
                        viewModel.onEvent(NoteEvent.ChangeTitleFocus(it))
                    },
                    isHintVisible = titleState.isHintVisible,
                    singleLine = true,
                    textStyle = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.height(16.dp))
                TransparentHintTextField(
                    text = contentState.text,
                    hint = contentState.hint,
                    onValueChange = {
                        viewModel.onEvent(NoteEvent.EnterContent(it))
                    },
                    onFocusChange = {
                        viewModel.onEvent(NoteEvent.ChangeContentFocus(it))
                    },
                    isHintVisible = contentState.isHintVisible,
                    singleLine = false,
                    textStyle = MaterialTheme.typography.body1
                )
            }
        }


    }

}

//    Column() {
//
//        TransparentHintTextField(
//            text = titleState.text,
//            hint = titleState.hint,
//            onValueChange =,
//            onFocusChange =
//        )
////        if(mode.value){
////            MarkdownText(markdown = markdown)
////        }else{
////            EditMode()
////        } TODO manage mode
//        NoteHelper()
//    }
@Destination
@Composable
fun EmptyNoteScreen() {
//    val mode = remember {
//    mutableStateOf(true)
//}
    Column() {
        Row() {
            Text(text = "Titre")
            NoteOption()
        }
//        if(mode.value){
//            MarkdownText(markdown = markdown)
//        }else{
//            EditMode()
//        } TODO Edit mode by default
        NoteHelper()
    }
}

@Composable
fun NoteHelper() {

}

@Composable
fun NoteOption() {

}

@Composable
fun EditMode() {

}
