package com.maddbrains.eurowingstask.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maddbrains.eurowingstask.domain.model.Image

class ImageDetailViewModelFactory (

    var image: Image? = null

) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageDetailViewModel(image) as T
    }
}