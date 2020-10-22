package com.maddbrains.eurowingstask.data.repository

import com.maddbrains.eurowingstask.data.api.ImageApi
import com.maddbrains.eurowingstask.data.db.AppDatabase
import com.maddbrains.eurowingstask.data.model.FeedResponse
import com.maddbrains.eurowingstask.domain.model.Image
import retrofit2.Response

class ImageRepository(
    private val api : ImageApi,
    private val db : AppDatabase
) {
    suspend fun galleryImages(section : String, sort : String, window : String) : Response<FeedResponse> {
        return api.getGalleryImages(section, sort, window, "1",
            showViral = true,
            showMature = true,
            albumPreview = true
        )
    }

    suspend fun saveImages(images : List<Image>) {
        db.getImageDao().deleteImages()
        db.getImageDao().saveImages(images)
    }

    suspend fun getAllSavedImages() : List<Image> {
        return db.getImageDao().getAllSavedImages()
    }
}