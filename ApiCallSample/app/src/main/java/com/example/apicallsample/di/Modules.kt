package com.example.apicallsample.di

import com.example.apicallsample.AppExecutors
import com.example.apicallsample.repository.MessageRepository
import com.example.apicallsample.ui.detail.MessageDetailViewModel
import com.example.apicallsample.ui.list.MessageListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { AppExecutors() }
    viewModel { MessageListViewModel(get()) }
    viewModel { MessageDetailViewModel(get()) }
}

val dataSourceModule = module {
    single { MessageRepository() }
}

val appModules = arrayListOf(appModule, dataSourceModule)