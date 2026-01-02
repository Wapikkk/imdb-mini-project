package com.wapekk.imdb.viewModel
import com.wapekk.imdb.model.Movie
import com.wapekk.imdb.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class ViewModelMovies (private val repository: MovieRepository) : ViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    init {
        fetchMovies()
    }

    private fun fetchMovies(){
        viewModelScope.launch {
            val result = repository.fetchMovies()
            _movies.value = result
        }
    }
}