package be.bf.kit3tsu.connect_the_books.ui.note

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import be.bf.kit3tsu.connect_the_books.ui.library.markdown
import dev.jeziellago.compose.markdowntext.MarkdownText

@Composable
fun NoteScreen(){
    val mode = remember {
    mutableStateOf(true)
}
    Column() {
        Row() {
            Text(text = "Titre")
            NoteOption()
        }
        if(mode.value){
            MarkdownText(markdown = markdown)
        }else{
            EditMode()
        }
        NoteHelper()
    }
}

@Composable
fun NoteHelper() {
    TODO("Not yet implemented")
}

@Composable
fun NoteOption() {
    TODO("Not yet implemented")
}

@Composable
fun EditMode() {
    TODO("Not yet implemented")
}
