package com.example.cardview

import com.example.cardview.model.Postagem

class PostagemRepository {

    suspend fun listaPostagens() = arrayListOf(
        Postagem("Postagem 1"),
        Postagem("Postagem 2"),
        Postagem("Postagem 3"),
        Postagem("Postagem 4")
    )

}