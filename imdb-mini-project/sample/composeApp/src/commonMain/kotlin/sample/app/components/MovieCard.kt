package sample.app.components
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.layout.*
import coil3.compose.AsyncImage
import com.wapekk.imdb.model.Movie

@Composable
fun MovieCard(movie: Movie) {
    val imageUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}"

    Card (
        elevation = 4.dp,
        modifier = Modifier.fillMaxWidth().padding(4.dp)
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            AsyncImage(
                model = imageUrl,
                contentDescription = movie.title,
                modifier = Modifier.width(100.dp).height(150.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Rating: ⭐ ${movie.voteAverage}")
            }
        }
    }
}