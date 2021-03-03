package com.example.themoviedb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.R
import com.example.themoviedb.data.model.Film
import com.google.android.material.card.MaterialCardView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item_for_table.view.*

class FilmsTableRecyclerAdapter(private val detailClicked: (Film)->Unit) :
    RecyclerView.Adapter<FilmsTableRecyclerAdapter.MyViewHolder>() {

    var itemList: MutableList<Film> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilmsTableRecyclerAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        val item = itemView.inflate(R.layout.recycler_item_for_table, parent, false)
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
        val cardView: MaterialCardView = view.card_view_table
        private val imageContainer = view.image_film_table
        private val nameContainer = view.name_film_table


        fun bind(film: Film) {
            val image = "https://www.themoviedb.org/t/p/original"+film.poster_path
            nameContainer.text = film.title
            Picasso.get()
                .load(image)
                .placeholder(R.drawable.loading)
                .error(R.drawable.loading)
                .into(imageContainer)
        }


    }

}




