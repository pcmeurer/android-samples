package com.example.recycler.ui.common

interface ActionCompletionContract {
    fun onViewMoved(oldPosition: Int, newPosition: Int)
    fun onViewSwiped(position: Int)
}