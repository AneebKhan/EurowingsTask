package com.maddbrains.eurowingstask.presentation.feed

import com.maddbrains.eurowingstask.data.mapper.ImageMapper
import com.maddbrains.eurowingstask.data.repository.ImageRepository
import com.maddbrains.eurowingstask.presentation.base.BaseViewModel
import com.maddbrains.eurowingstask.presentation.util.Coroutines

class FeedViewModel(
    private val repository: ImageRepository
) : BaseViewModel() {

    var feedListener: FeedListener? = null

    fun getGalleryImages(section : String, sort : String, window : String) {
        Coroutines.main {
            val feedResponse = repository.galleryImages(section, sort, window)
            if (feedResponse.isSuccessful) {
                feedResponse.body()?.data?.let {
                    val result = it.map { imgMap ->
                        ImageMapper.convertData(imgMap)
                    }
                    feedListener?.onSuccess(result)
                    repository.saveImages(result)
                    return@main
                }
            } else
                feedListener?.onFailure("Error Code: ${feedResponse.code()}")
        }

    }

    fun getCachedGalleryImages() {
        Coroutines.main {
            val savedImages = repository.getAllSavedImages()
            feedListener?.onSuccess(savedImages)
        }
    }
}