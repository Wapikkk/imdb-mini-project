package sample.app.screens
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import sample.app.components.MovieCard
import com.wapekk.imdb.viewModel.ViewModelMovies

@Composable
fun MovieListScreen(viewModel: ViewModelMovies) {
    val movie by viewModel.movies.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ){
        Text(text = "IMDb Mini Project", style = MaterialTheme.typography.h4)
        Spacer(
            modifier = Modifier.height(16.dp)
        )

        if (movie.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        } else {
            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(items = movie) { movie ->
                    MovieCard(movie)
                }
            }
        }
    }
}