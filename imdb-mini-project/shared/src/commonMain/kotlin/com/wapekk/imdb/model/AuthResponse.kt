package com.wapekk.imdb.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class AuthResponse(
    val message: String,

    @SerialName("success")
    val success: Boolean
)