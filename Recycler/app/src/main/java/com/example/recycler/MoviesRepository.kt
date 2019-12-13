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
        Movie("A Múmia", "Terror", "2017"),
        Movie("A Bela e a Fera", "Romance", "2017"),
        Movie("Meu malvado favorito 3", "Comédia", "2017"),
        Movie("Carros 3", "Comédia", "2017"),
        Movie("Pantera Negra", "Ação", "2018"),
        Movie("Vingadores: Guerra Infinita", "Ação", "2018"),
        Movie("Os Incríveis 2", "Ação", "2018"),
        Movie("Vingadores: Ultimato", "Ação", "2019")
    )
}