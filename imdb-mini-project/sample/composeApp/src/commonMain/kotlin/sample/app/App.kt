package sample.app

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.*
import com.wapekk.imdb.repository.MovieRepository
import com.wapekk.imdb.viewModel.ViewModelMovies
import sample.app.screens.*

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
        scene("login") {
            LoginScreen (
                onLoginSuccess = {navigator.navigate("movies")},
                onRegisterClicked = {navigator.navigate("register")}
            )
        }
        scene("register") {
            RegisterScreen (onRegisterSuccess = { navigator.navigate("login")})
        }
        scene("movies") {
            val repository = MovieRepository()
            val viewModel = ViewModelMovies(repository)
            MovieListScreen(viewModel = viewModel)
        }
    }
}