package com.example.themoviedb.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.data.model.Film
import com.example.themoviedb.data.model.FilmPager
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val homeRepository = HomeRepo()

    val filmsLiveData = MutableLiveData<FilmPager>()

    var oneFilm = MutableLiveData<Film>()

    fun getFilms() {
        viewModelScope.launch { filmsLiveData.postValue(homeRepository.getFilms()) }
    }

    fun filmDetail(film: Film) {
        oneFilm.value = film
    }

}