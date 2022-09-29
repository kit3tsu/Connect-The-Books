package be.bf.kit3tsu.connect_the_books.ui.note

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun NoteScreen(note: Note, navigator: DestinationsNavigator) {
    Column() {
        Row() {
            Text(text = note.name)
            NoteOption()
        }
//        if(mode.value){
//            MarkdownText(markdown = markdown)
//        }else{
//            EditMode()
//        } TODO manage mode
        NoteHelper()
    }
}

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
