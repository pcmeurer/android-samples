package com.example.recycler

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingComponent
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.recycler.model.Movie
import com.example.recycler.ui.common.SwipeAndDragHelper
import kotlinx.android.synthetic.main.activity_movies.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesActivity : AppCompatActivity(), MovieClickCallback {

    private val appExecutors: AppExecutors by inject()
    private val dataBindingComponent = object : DataBindingComponent {}
    private val viewModel: MoviesViewModel by viewModel()
    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        initViewComponents()
        initMoviesList()
    }

    private fun initViewComponents() {
        adapter = MoviesAdapter(dataBindingComponent, appExecutors, this)
        recyclerMovies.adapter = adapter
        recyclerMovies.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        val swipeAndDragHelper = SwipeAndDragHelper(adapter)
        val itemTouchHelper = ItemTouchHelper(swipeAndDragHelper)
        itemTouchHelper.attachToRecyclerView(recyclerMovies)
    }

    private fun initMoviesList() {
        viewModel.movies.observe(
            this,
            Observer { movies ->
                adapter.submitList(movies)
            }
        )
    }

    override fun onMovieClick(movie: Movie) {
        Toast.makeText(this, movie.titulo, Toast.LENGTH_LONG).show()
    }
}
