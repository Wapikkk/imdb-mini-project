package sample.app
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wapekk.imdb.Movie
import com.wapekk.imdb.ViewModel.ViewModelMovies

@Composable
fun MovieListScreen(viewModel: ViewModelMovies) {
    val movies by viewModel.movies.collectAsState()

    LazyColumn {
        items(items = movies) { movie: Movie ->
            Text(
                text = movie.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}