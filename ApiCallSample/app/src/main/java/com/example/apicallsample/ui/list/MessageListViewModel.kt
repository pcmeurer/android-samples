package com.example.apicallsample.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.apicallsample.model.Message
import com.example.apicallsample.repository.MessageRepository

class MessageListViewModel (val repository: MessageRepository) : ViewModel() {

    val messages: LiveData<List<Message>> = repository.getMessages().asLiveData()
}