package com.example.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.example.recycler.databinding.ListItemMovieBinding
import com.example.recycler.model.Movie
import com.example.recycler.ui.common.ActionCompletionContract
import com.example.recycler.ui.common.DataBoundListAdapter

class MoviesAdapter(
    private val dataBindingComponent: DataBindingComponent,
    appExecutors: AppExecutors,
    private val movieClickCallback: MovieClickCallback
) : DataBoundListAdapter<Movie, ListItemMovieBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie) =
            oldItem.titulo == newItem.titulo
                    && oldItem.ano == newItem.ano
                    && oldItem.categoria == newItem.categoria
    }
), ActionCompletionContract {
    override fun createBinding(parent: ViewGroup): ListItemMovieBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_movie,
            parent,
            false,
            dataBindingComponent
        )
    }

    override fun bind(binding: ListItemMovieBinding, item: Movie, position: Int) {
        binding.movie = item
        binding.callback = movieClickCallback
    }

    override fun onViewMoved(oldPosition: Int, newPosition: Int) {
        notifyItemMoved(oldPosition, newPosition)
    }

    override fun onViewSwiped(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}