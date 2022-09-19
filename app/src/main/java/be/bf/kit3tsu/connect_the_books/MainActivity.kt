package be.bf.kit3tsu.connect_the_books

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.bf.kit3tsu.connect_the_books.ui.library.books
import be.bf.kit3tsu.connect_the_books.ui.library.directory.FolderScreen
import be.bf.kit3tsu.connect_the_books.ui.library.home.HomeScreen
import be.bf.kit3tsu.connect_the_books.ui.library.notes
import be.bf.kit3tsu.connect_the_books.ui.theme.ConnectTheBooksTheme
import dev.jeziellago.compose.markdowntext.MarkdownText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConnectTheBooksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        //FolderScreen(notes)
                        HomeScreen()
//                        Greeting("Android")
//                        ComplexExampleContent()
//                        MinimalExampleContent()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//Minimal example
@Composable
fun MinimalExampleContent() {
    MarkdownText(markdown = """  
	# Sample  
    ## Hé title
	* Markdown  
	* [Link](https://example.com)  
	![Image](https://example.com/img.png)  
	<a href="https://www.google.com/">Google</a>  
""")
}
 val test = "  # Sample \n" +
        // "## Hé title\n" +
         " <a href=\"https://www.google.com/\">Google</a>    \n"
//Complex example
@Composable
fun ComplexExampleContent() {
    MarkdownText(
        modifier = Modifier.padding(8.dp),
        markdown = test,
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        color = LocalContentColor.current,
        maxLines = 3,
        style = MaterialTheme.typography.overline,
        )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ConnectTheBooksTheme {
        Column() {
            Greeting("Android")
            MinimalExampleContent()
            ComplexExampleContent()
        }

    }
}