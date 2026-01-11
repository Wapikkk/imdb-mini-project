package com.wapekk.imdb.repository
import com.wapekk.imdb.model.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class AuthRepository(private val client: HttpClient) {
    suspend fun register(request: RegisterRequest): AuthResponse {
        return try {
            val response = client.post("http://192.168.0.113:8080/register") {
                contentType(ContentType.Application.Json)
                setBody(request)
            }
            response.body()
        } catch (e: Exception) {
            AuthResponse(message = "Gagal terhubung ke server", success = false)
        }
    }

    suspend fun login(request: LoginRequest): AuthResponse {
        return try {
            val response = client.post("http://192.168.0.113:8080/login") {
                contentType(ContentType.Application.Json)
                setBody(request)
            }
            response.body()
        } catch (e: Exception) {
            println("DEBUG_AUTH: ${e.message}")
            e.printStackTrace()
            AuthResponse(message = "Gagal Terhubung ke Server", success = false)
        }
    }
}