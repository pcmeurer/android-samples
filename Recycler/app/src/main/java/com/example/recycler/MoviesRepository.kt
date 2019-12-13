package com.example.recycler

import com.example.recycler.model.Movie

class MoviesRepository {

    suspend fun listaFilmes() = arrayListOf(
        Movie("Homem Aranha - De volta ao lar", "Aventura", "2017"),
        Movie("Mulher Maravilha", "Fantasia", "2017"),
        Movie("Liga da Justiça", "Ficção", "2017"),
        Movie("Capitão América - Guerra Civil", "Aventura/Ficção", "2016"),
        Movie("It: A Coisa", "Drama/Terror", "2017"),
        Movie("Pica-Pau: O Filme", "Comédia/Animação", "2017"),
        Movie("A Múmia", "Terror", "2017")
    )
}