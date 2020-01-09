package com.example.apicallsample.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.apicallsample.model.Message
import com.example.apicallsample.repository.MessageRepository

class MessageDetailViewModel(repository: MessageRepository) : ViewModel() {

    private val _query = MutableLiveData<Int>()
    val message: LiveData<Message> = _query.switchMap { messageID ->
        repository.getMessage(messageID)
    }

    fun setQuery(messageID: Int){
        _query.value = messageID
    }
}