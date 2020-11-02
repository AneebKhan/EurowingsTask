package com.maddbrains.imgur.presentation.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maddbrains.imgur.data.repository.ImageRepository

class FeedViewModelFactory(
    private val repository: ImageRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FeedViewModel(repository) as T
    }
}