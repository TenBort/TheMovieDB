package com.example.themoviedb.data

import java.net.URL


object Constants {

    var BaseURL = URL("https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=a49cf8a5f42225880f049917a2262e81")

    fun getFilms() = BaseURL

}