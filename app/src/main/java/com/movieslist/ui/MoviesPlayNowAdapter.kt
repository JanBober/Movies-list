package com.movieslist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.domain.entities.model.MoviesPlayNow
import com.domain.entities.model.Results
import com.movieslist.databinding.MovieItemBinding

class MoviesPlayNowAdapter : RecyclerView.Adapter<MoviesPlayNowAdapter.MainViewHolder>() {

    var onClick: (Results) -> Unit = {}
    private var movies = ArrayList<Results>()

    fun addListMovie(moviesPlayNow: MoviesPlayNow) {
        this.movies = moviesPlayNow.results
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainViewHolder(
        MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(
            movies[position],
            onClick
        )
    }

    class MainViewHolder(
        private val binding: MovieItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        // TODO: Not yet implemented
        fun bind(
            results: Results,
            onClick: (Results) -> Unit
        ) {
            with(binding) {
                title = results.title
            }
        }
    }
}
