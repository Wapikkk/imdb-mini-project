package com.wapekk.imdb.repository
import com.wapekk.imdb.model.Movie
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class MovieRepository(private val httpClient: HttpClient) {

    suspend fun fetchMovies(): List<Movie> {
        return try {
            return httpClient.get("http://10.0.2.2:8080/movies").body()
        } catch (e: Exception) {
            println("Gagal memuat Film: ${e.message}")
            emptyList()
        }
    }
}