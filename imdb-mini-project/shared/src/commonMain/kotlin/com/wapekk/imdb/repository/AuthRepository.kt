package com.wapekk.imdb.repository
import com.wapekk.imdb.model.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class AuthRepository(private val client: HttpClient) {
//  Autentikasi Registrasi
    suspend fun register(request: RegisterRequest): AuthResponse {
        return try {
            val response = client.post("http://10.0.2.2:8080/register") {
                contentType(ContentType.Application.Json)
                setBody(request)
            }
            response.body()
        } catch (e: Exception) {
            AuthResponse(message = "Gagal terhubung ke server", success = false)
        }
    }
//  Autentikasi Login
    suspend fun login(request: LoginRequest): AuthResponse {
        return try {
            val response = client.post("http://10.0.2.2:8080/login") {
                contentType(ContentType.Application.Json)
                setBody(request)
            }
            response.body()
        } catch (e: Exception) {
            AuthResponse(message = "Gagal Terhubung ke Server", success = false)
        }
    }
}