package sample.app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.wapekk.imdb.viewModel.ViewModelMovies
import sample.app.screens.MovieListScreen

@Composable
fun MovieApp(viewModel: ViewModelMovies) {
    MaterialTheme {
        MovieListScreen(viewModel)
    }
}