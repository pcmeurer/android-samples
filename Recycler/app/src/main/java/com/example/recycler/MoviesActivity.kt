package com.example.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingComponent
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_movies.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesActivity : AppCompatActivity() {

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
        adapter = MoviesAdapter(dataBindingComponent, appExecutors)
        recyclerMovies.adapter = adapter
    }

    private fun initMoviesList() {
        viewModel.movies.observe(
            this,
            Observer { movies ->
                adapter.submitList(movies)
            }
        )
    }
}
