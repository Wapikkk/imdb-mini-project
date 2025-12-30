package com.wapekk.imdb.model

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    val fullName: String,
    val phone: String,
    val email: String,
    val password: String
)