package com.wapekk.imdb.repository
import com.wapekk.imdb.model.Movie
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class MovieRepository {
    private var httpClient = HttpClient {
        install (ContentNegotiation) {
            json(Json{
                ignoreUnknownKeys = true
                coerceInputValues = true
            })
        }
    }

    suspend fun fetchMovies(): List<Movie> {
        return httpClient.get("http://10.0.2.2:8080/movies").body()
    }
}