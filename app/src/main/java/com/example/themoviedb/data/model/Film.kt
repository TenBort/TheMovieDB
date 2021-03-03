package com.example.themoviedb.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class FilmPager(
    @SerialName("page")
    val page : Int = 0,
    @SerialName("results")
    val results : List<Film> = listOf()
)
@Serializable
data class Film(

    @SerialName(value = "adult")
    val adult: Boolean = false,
    @SerialName(value = "backdrop_path")
    val backdrop_path: String = "",
    @SerialName(value = "id")
    val id: Int = 0,
    @SerialName(value = "original_language")
    val original_language: String = "",
    @SerialName(value = "original_title")
    val original_title: String = "",
    @SerialName(value = "overview")
    val overview: String = "",
    @SerialName(value = "popularity")
    val popularity: Float = 0F,
    @SerialName(value = "poster_path")
    val poster_path: String = "",
    @SerialName(value = "release_date")
    val release_date: String = "",
    @SerialName(value = "title")
    val title: String = "",
    @SerialName(value = "video")
    val video: Boolean = false,
    @SerialName(value = "vote_average")
    val vote_average: Float = 0F,
    @SerialName(value = "vote_count")
    val vote_count: Int = 0
    )



