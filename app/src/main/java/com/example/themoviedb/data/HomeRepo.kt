package com.example.themoviedb.data

import com.example.themoviedb.data.model.FilmPager

class HomeRepo {
    private val api: ApiService = ApiService()

    suspend fun getFilms(): FilmPager = api.getFilms()
}