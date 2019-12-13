package com.example.recycler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.recycler.model.Movie

class MoviesViewModel(private val repository: MoviesRepository) : ViewModel() {

    val movies = liveData<List<Movie>> {
        emit(repository.listaFilmes())
    }

}