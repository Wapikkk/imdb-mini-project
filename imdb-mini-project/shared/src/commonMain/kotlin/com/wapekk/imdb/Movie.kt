package com.wapekk.imdb
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,

    @SerialName("poster_path")
    val posterPath: String,

    @SerialName("vote_average")
    val voteAverage: Double
)
