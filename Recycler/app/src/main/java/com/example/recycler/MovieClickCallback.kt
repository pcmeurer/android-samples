package com.example.recycler

import com.example.recycler.model.Movie

interface MovieClickCallback {
    fun onMovieClick(movie: Movie)
}