package com.example.themoviedb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.R
import com.example.themoviedb.data.model.Film
import com.google.android.material.card.MaterialCardView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item_for_list.view.*

class FilmsListRecyclerAdapter(private val detailClicked: (Film)->Unit) :
    RecyclerView.Adapter<FilmsListRecyclerAdapter.MyViewHolder>() {

    var itemList: MutableList<Film> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilmsListRecyclerAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        val item = itemView.inflate(R.layout.recycler_item_for_list, parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemList[position])

        holder.cardView.setOnClickListener {
            detailClicked.invoke(itemList[position])
        }
    }

    override fun getItemCount() = itemList.size

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: MaterialCardView = view.card_view_list
        private val imageContainer = view.image_film_list
        private val nameContainer = view.name_film_list
        private val rateContainer = view.rate_film_list
        private val dateContainer = view.date_film_list
        private val descriptionContainer = view.description_film_list

        fun bind(film: Film) {

            nameContainer.text = film.title
            dateContainer.text = film.release_date
            rateContainer.text = "rate: ${film.vote_average}/10"
            descriptionContainer.text = film.overview

            val image = "https://www.themoviedb.org/t/p/original"+film.poster_path

            Picasso.get()
                .load(image)
                .placeholder(R.drawable.loading)
                .error(R.drawable.loading)
                .into(imageContainer)
        }

    }

}




