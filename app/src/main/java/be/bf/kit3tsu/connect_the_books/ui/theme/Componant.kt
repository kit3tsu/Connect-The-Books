package be.bf.kit3tsu.connect_the_books.ui.theme

import android.content.res.Configuration
import android.graphics.drawable.Icon
import android.service.autofill.OnClickAction
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(onClickAction: () -> Unit, text: String) {
    Button(
        onClick = { onClickAction },
        modifier = Modifier,
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
        contentPadding = PaddingValues(8.dp),
    ) {
        ButtonText(text)
    }
}

@Composable
fun MyTopAppBar() {
    TopAppBar() {

    }
}

@Composable
fun MyBottomAppBar() {
    BottomAppBar() {

    }
}

@Composable
fun ButtonText(text: String) {
    Text(
        text = text,
        color = MaterialTheme.colors.onSecondary,
        modifier = Modifier,
        maxLines = 1
    )
}

@Composable
fun AppSearchBar(
    onSearchBook: () -> Unit,
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(value = text, onValueChange = onTextChange)
        IconButtonApp(Icons.Default.Search, "Look for a book", onSearchBook)
    }
}

@Composable
fun IconButtonApp(imageVector: ImageVector, contentDescription: String, onClickAction: () -> Unit) {
    Box(modifier = Modifier.clickable { onClickAction }) {
        Icon(imageVector = imageVector, contentDescription = contentDescription)
    }
}

//@Composable
//fun ButtonWithIcon() {
//    Button(onClick = {}) {
//        Image(
//            painterResource(id = R.drawable.ic_cart),
//            contentDescription ="Cart button icon",
//            modifier = Modifier.size(20.dp))
//
//        Text(text = "Add to cart",Modifier.padding(start = 10.dp))
//    }
//} //FIXME
@Preview(showBackground = true)
@Composable
fun PreviewAppButton() {
    ConnectTheBooksTheme {
        AppButton(onClickAction = { }, text = "Click Me")
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun PreviewAppButtonDark() {
    ConnectTheBooksTheme {
        AppButton(onClickAction = { }, text = "Click Me")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppSearchBar() {
    ConnectTheBooksTheme {
        AppSearchBar({}, "Research", {})
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun PreviewDarkAppSearchBar() {
    ConnectTheBooksTheme {
        AppSearchBar({}, "Research", {})
    }
}
// @Preview(showBackground = true)
//@Composable
//fun Preview() {
//    ConnectTheBooksTheme {
//
//    }
//}
//
//@Preview(
//    showBackground = true,
//    widthDp = 320,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    name = "DefaultPreviewDark"
//)
//@Composable
//fun PreviewnDark() {
//    ConnectTheBooksTheme {
//
//    }
//}