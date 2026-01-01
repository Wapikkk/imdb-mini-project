package com.wapekk.imdb.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val message: String,
    val success: Boolean
)