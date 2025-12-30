package sample.app

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.*
import com.wapekk.imdb.repository.MovieRepository
import com.wapekk.imdb.viewModel.ViewModelMovies
import sample.app.screens.LandingPageScreen
import sample.app.screens.MovieListScreen
import sample.app.screens.RegisterScreen

@Composable
fun MovieApp() {
    val navigator = rememberNavigator()

    NavHost(
        navigator = navigator,
        initialRoute = "landing"
    ) {
        scene("landing") {
            LandingPageScreen (onStartClicked = { navigator.navigate("register")})
        }
        scene("register") {
            RegisterScreen (onRegisterSuccess = { navigator.navigate("movies")})
        }
        scene("movies") {
            val repository = MovieRepository()
            val viewModel = ViewModelMovies(repository)
            MovieListScreen(viewModel = viewModel)
        }
    }
}