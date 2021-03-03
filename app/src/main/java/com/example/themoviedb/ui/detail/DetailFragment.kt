package com.example.themoviedb.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.themoviedb.R
import com.example.themoviedb.data.HomeViewModel
import com.example.themoviedb.data.model.Film
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {

    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.oneFilm.value?.let { detailView(it) }
    }
    private fun detailView(film: Film) {

        val image = "https://www.themoviedb.org/t/p/original" + film.poster_path

        toolbar_detail.title = film.title
        overview_detail.text = film.overview
        rate_detail.text = "rate: ${film.vote_average}/10"
        popularity_detail.text = "popularity: ${film.popularity}"
        date_detail.text = film.release_date
        original_language_detail.text = "original language: ${film.original_language}"


        Picasso.get()
            .load(image)
            .placeholder(R.drawable.loading)
            .error(R.drawable.loading)
            .into(image_detail)
    }
}



