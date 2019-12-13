package com.example.cardview.di

import com.example.cardview.PostagemRepository
import com.example.cardview.PostagemViewModel
import com.example.recycler.AppExecutors
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cardviewAppModule = module {
    single { AppExecutors() }
    viewModel { PostagemViewModel(get()) }
}

val datasourceModule = module {
    single { PostagemRepository() }
}

val appModules = arrayListOf(cardviewAppModule, datasourceModule)