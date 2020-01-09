package com.example.apicallsample.repository

import com.example.apicallsample.model.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MessageRepository {

    fun getMessages(): Flow<List<Message>> = flow {
        emit(
            arrayListOf(
                Message(1, "Test1", "Test1 Message"),
                Message(2, "Test2", "Test2 Message"),
                Message(3, "Test3", "Test3 Message")
            )
        )
    }
}