package com.example.apicallsample.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.apicallsample.model.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MessageRepository {

    val messages = arrayListOf(
        Message(1, "Test 1", "Test 1 Message Content"),
        Message(2, "Test 2", "Test 2 Message Content"),
        Message(3, "Test 3", "Test 3 Message Content")
    )

    fun getMessages(): Flow<List<Message>> =
        flow {
            emit(messages)
        }

    // TODO: change Message to Resource
    fun getMessage(id: Int): LiveData<Message> =
        liveData {
            emit(
                messages[1]
            )
        }
}