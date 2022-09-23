package be.bf.kit3tsu.connect_the_books.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)
val LightColors = lightColors(
    primary = CariolinaBlue,
    primaryVariant = GreenBlueCrayola,
    onPrimary = Xiketic,
    secondary = OrangeRedCrayola,
    secondaryVariant = Red,
    onSecondary = Xiketic,
    surface = UranianBlue,
    onSurface = XiketicDarker,
    error = Red800
)

// val DarkColors = darkColors(
//    primary = Red300,
//    primaryVariant = Red700,
//    onPrimary = Color.Black,
//    secondary = Red300,
//    onSecondary = Color.Black,
//    error = Red200
//)
val DarkColors = darkColors(
    primary = DarkPurple,
    primaryVariant = DarkPurpleDarker,
    onPrimary = Magnolia,
    secondary = RussianViolet,
    secondaryVariant = RussianVioletDarker,
    onSecondary = Magnolia,
    surface = XiketicDarker,
    onSurface = Magnolia,
    error = Red200
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun ConnectTheBooksTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content,
        colors = if (darkTheme) DarkColors else LightColors,
        typography = ConnectTheBooksTypography,
        shapes = ConnectTheBooksShapes
    )
}