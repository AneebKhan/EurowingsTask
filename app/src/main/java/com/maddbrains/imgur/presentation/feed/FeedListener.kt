package com.maddbrains.imgur.presentation.feed

import com.maddbrains.imgur.domain.model.Image

interface FeedListener {
    fun onSuccess(imgList : List<Image>)
    fun onFailure(message : String)
}