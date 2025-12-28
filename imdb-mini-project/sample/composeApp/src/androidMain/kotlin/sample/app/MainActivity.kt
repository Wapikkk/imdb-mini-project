package sample.app
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.material.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wapekk.imdb.Movie
import com.wapekk.imdb.ViewModel.ViewModelMovies

@Composable
fun MovieApp(viewModel: ViewModelMovies) {
    val movies by viewModel.movies.collectAsState()

    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text(
                text = "IMDb Mini Project",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            if (movies.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(movies) { movie ->
                        MovieCard(movie)
                    }
                }
            }
        }
    }
}

@Composable
fun MovieCard(movie: Movie) {
    Card(elevation = 4.dp, modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(60.dp).background(Color.Gray))

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Rating: ${movie.vote_average}", color = Color.DarkGray)
            }
        }
    }
}