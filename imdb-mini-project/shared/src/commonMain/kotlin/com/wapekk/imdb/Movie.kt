package com.wapekk.imdb
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val vote_average: Double
)
