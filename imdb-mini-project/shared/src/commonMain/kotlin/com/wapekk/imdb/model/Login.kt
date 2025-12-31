package com.wapekk.imdb.model
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email: String,
    val password: String
)

@Serializable
data class AuthResponse(
    val message: String,
    val success: Boolean
)