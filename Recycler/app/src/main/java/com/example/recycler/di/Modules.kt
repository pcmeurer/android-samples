package com.example.recycler.di

import com.example.recycler.AppExecutors
import com.example.recycler.MoviesRepository
import com.example.recycler.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val recyclerAppModule =module{
    single { AppExecutors() }
    viewModel { MoviesViewModel(get()) }

}

val datasourceModule = module {
    single { MoviesRepository() }
}

val appModules = arrayListOf(recyclerAppModule, datasourceModule)