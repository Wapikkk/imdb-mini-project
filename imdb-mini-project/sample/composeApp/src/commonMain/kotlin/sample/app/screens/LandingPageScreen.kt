package sample.app.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.*
import imdb_mini_project.sample.composeapp.generated.resources.Res
import imdb_mini_project.sample.composeapp.generated.resources.logo_imdb
import org.jetbrains.compose.resources.painterResource

@Composable
fun LandingPageScreen(
    onStartClicked: () -> Unit
){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.logo_imdb),
                contentDescription = "Imdb Logo",
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 24.dp)
            )
            Text(
                "Selamat Datang",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onBackground
            )
            Text(
                "Temukan Film Favoritmu di IMDb Mini",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground.copy(alpha = 0.7f)
            )

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            Button(
                onClick = onStartClicked,
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    "Mulai",
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}
