package sample.app.theme

import androidx.compose.ui.text.*
import androidx.compose.ui.unit.sp
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.*
import org.jetbrains.compose.resources.Font
import imdb_mini_project.sample.composeapp.generated.resources.Res
import imdb_mini_project.sample.composeapp.generated.resources.merriweather_italic
import imdb_mini_project.sample.composeapp.generated.resources.merriweather_regular
import imdb_mini_project.sample.composeapp.generated.resources.robotoSlab_regular

@Composable
fun getImdbTypography(): Typography {

    val merriweatherFontFamily = FontFamily(
        Font(Res.font.merriweather_italic),
        Font(Res.font.merriweather_regular)
    )

    val robotoSlab_regular = FontFamily(
        Font(Res.font.robotoSlab_regular)
    )

    return Typography(
        h4 = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.W800,
            fontSize = 30.sp
        ),
        body1 = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        body2 = TextStyle (
            fontFamily = robotoSlab_regular,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
}