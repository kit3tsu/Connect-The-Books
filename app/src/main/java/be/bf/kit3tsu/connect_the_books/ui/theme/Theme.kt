package be.bf.kit3tsu.connect_the_books.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

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
    primary = JungleGreen,
    primaryVariant = Genoa,
    onPrimary = Xiketic,
    secondary = Shamrock,
    secondaryVariant = Riptide,
    onSecondary = Xiketic,
    surface = MintTulip,
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
    primary = NavyBlue,
    primaryVariant = DarkBlue,
    onPrimary = Magnolia,
    secondary = Blue,
    secondaryVariant = BabyBlue,
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