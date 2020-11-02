package com.maddbrains.imgur.data.mapper

import com.maddbrains.imgur.data.model.ImageResponse
import com.maddbrains.imgur.domain.model.Image

object ImageMapper {

    fun convertData(imageResponse: ImageResponse): Image {
        return Image(
            id = imageResponse.id,
            title = imageResponse.title,
            description = imageResponse.images?.get(0)?.description,
            ups = imageResponse.ups,
            downs = imageResponse.downs,
            score = imageResponse.score,
            imageUrl = imageResponse.images?.get(0)?.link
        )
    }
}