package com.maddbrains.eurowingstask.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maddbrains.eurowingstask.domain.model.Image

@Dao
interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveImages(images: List<Image>)

    @Query("DELETE FROM Image")
    suspend fun deleteImages()

    @Query("SELECT * FROM Image")
    suspend fun getAllSavedImages() : List<Image>
}