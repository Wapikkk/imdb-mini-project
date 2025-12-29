package sample.app.components
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*
import com.wapekk.imdb.model.Movie

@Composable
fun MovieCard(movie: Movie) {
    Card (elevation = 4.dp, modifier = Modifier.fillMaxWidth() ){
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(60.dp).background(Color.Gray))
            Spacer(modifier = Modifier.width(16.dp))
            Column{
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Rating: ${movie.voteAverage}", color = Color.DarkGray)
            }
        }
    }
}