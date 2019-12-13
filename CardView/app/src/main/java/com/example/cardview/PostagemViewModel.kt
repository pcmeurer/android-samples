package com.example.cardview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class PostagemViewModel(repo: PostagemRepository) : ViewModel(){

    val listaPostagens = liveData {
        emit(repo.listaPostagens())
    }
}