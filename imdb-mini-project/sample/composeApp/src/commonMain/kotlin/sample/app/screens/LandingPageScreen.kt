package sample.app.screens
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign

@Composable
fun LandingPageScreen(onStartClicked: () -> Unit) {
    Column (
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Selamat Datang", style = MaterialTheme.typography.h3)
        Text("Temukan Film Favoritmu di IMDb Mini", textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onStartClicked, modifier = Modifier.fillMaxWidth()) {
            Text("Mulai")
        }
    }
}
