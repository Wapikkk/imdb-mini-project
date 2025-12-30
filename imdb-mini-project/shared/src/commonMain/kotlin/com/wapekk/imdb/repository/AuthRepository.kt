package com.wapekk.imdb.repository
import com.wapekk.imdb.model.RegisterRequest
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class AuthRepository(private val client: HttpClient) {
    suspend fun register(request: RegisterRequest): Boolean {
        return try {
            val response = client.post("http://10.0.2.2:8080/register") {
                contentType(ContentType.Application.Json)
                setBody(request)
            }
            response.status == HttpStatusCode.Created
        } catch (e: Exception) {
            false
        }
    }
}