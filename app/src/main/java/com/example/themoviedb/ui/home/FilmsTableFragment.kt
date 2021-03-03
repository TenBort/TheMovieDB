package com.example.themoviedb.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.themoviedb.R
import com.example.themoviedb.adapters.FilmsTableRecyclerAdapter
import com.example.themoviedb.data.HomeViewModel
import com.example.themoviedb.data.model.Film
import kotlinx.android.synthetic.main.fragment_films_table.*

class FilmsTableFragment : Fragment() {

    private val adapterRecycler = FilmsTableRecyclerAdapter(::detailClicked)
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_films_table, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val glm = GridLayoutManager(this.context,3)
        recycler_view_table.layoutManager = glm
        recycler_view_table.adapter = adapterRecycler
        observeLiveData()
    }

    private fun detailClicked(film: Film) {
        viewModel.filmDetail(film)
        findNavController().navigate(R.id.action_nav_home_to_detailFragment)
    }

    private fun observeLiveData() {
        viewModel.getFilms()
        viewModel.filmsLiveData.observe(viewLifecycleOwner, Observer {
            adapterRecycler.itemList.addAll(it.results)
            adapterRecycler.notifyDataSetChanged()
        })
    }

}