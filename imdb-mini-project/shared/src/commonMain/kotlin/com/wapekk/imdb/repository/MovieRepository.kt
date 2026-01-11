package com.wapekk.imdb.repository
import com.wapekk.imdb.model.Movie
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class MovieRepository(private val client: HttpClient) {

    suspend fun fetchMovies(): List<Movie> {
        return try {
            client.get("http://192.168.0.113:8080/movies").body()
        } catch (e: Exception) {
            println("Gagal memuat Film: ${e.message}")
            emptyList()
        }
    }
}