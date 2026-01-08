package sample.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import moe.tlaster.precompose.navigation.*
import moe.tlaster.precompose.viewmodel.viewModel
import com.wapekk.imdb.repository.*
import com.wapekk.imdb.viewModel.*
import sample.app.screens.*
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

@Composable
fun MovieApp() {
    val navigator = rememberNavigator()

    val client = remember {
        HttpClient {
            install(ContentNegotiation) {
                json(Json{ignoreUnknownKeys = true})
            }
        }
    }
    val authRepository = remember { AuthRepository(client) }
    val movieRepository = remember { MovieRepository(client) }

    NavHost(
        navigator = navigator,
        initialRoute = "landing"
    ) {
        scene("landing") {
            LandingPageScreen (onStartClicked = { navigator.navigate("register")})
        }
        scene("login") {
            val vm = viewModel(ViewModelAuth::class) { ViewModelAuth(authRepository) }
            LoginScreen (
                viewModel = vm,
                onLoginSuccess = {navigator.navigate("movies")},
                onRegisterClicked = {navigator.navigate("register")}
            )
        }
        scene("register") {
            val vm = viewModel(ViewModelAuth::class) { ViewModelAuth(authRepository) }
            RegisterScreen (
                viewModel = vm,
                onLoginSuccess = { navigator.navigate("login") },
                onRegisterSuccess = {navigator.navigate("login")}
            )
        }
        scene("movies") {
            val vm = viewModel(ViewModelMovies::class) { ViewModelMovies(movieRepository) }
            MovieListScreen(viewModel = vm)
        }
    }
}