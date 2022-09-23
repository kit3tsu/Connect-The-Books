package be.bf.kit3tsu.connect_the_books.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val ConnectTheBooksShapes = Shapes(
small = RoundedCornerShape( 8.dp),
medium = CutCornerShape(topStart = 8.dp,
    topEnd = 8.dp,
    bottomEnd = 8.dp,
    bottomStart = 8.dp),
large = RoundedCornerShape(topStart = 12.dp)
)

