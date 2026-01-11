package sample.app.screens
import com.wapekk.imdb.viewModel.ViewModelMovies
import sample.app.components.MovieCard
import sample.app.components.NavBar

import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*

@Composable
fun HomeScreen(viewModel: ViewModelMovies) {
    var selectedTab by remember{mutableStateOf(0)}

    Scaffold (
        bottomBar = {
            NavBar(
                selectedTab = selectedTab,
                onTabSelected = {index -> selectedTab = index}
            )
        }
    ){ innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when(selectedTab) {
                0 -> MovieListContent(viewModel)
                1 -> ProfileScreen()
            }
        }
    }
}

@Composable
fun MovieListContent(viewModel: ViewModelMovies) {
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