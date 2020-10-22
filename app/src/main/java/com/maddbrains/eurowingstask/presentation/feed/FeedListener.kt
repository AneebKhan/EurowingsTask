package com.maddbrains.eurowingstask.presentation.feed

import com.maddbrains.eurowingstask.domain.model.Image

interface FeedListener {
    fun onSuccess(imgList : List<Image>)
    fun onFailure(message : String)
}