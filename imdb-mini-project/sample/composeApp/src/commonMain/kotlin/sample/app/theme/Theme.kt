package sample.app.theme

import androidx.compose.material.*
import androidx.compose.runtime.Composable

private val ImdbColorPalette = lightColors(
    primary = ImdbYellow,
    background = ImdbWhite,
    surface = ImdbWhite,
    onPrimary = ImdbBlack,
    onBackground = ImdbBlack
)

@Composable
fun ImdbTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = ImdbColorPalette,
        typography = getImdbTypography(),
        shapes = ImdbShape,
        content = content
    )
}