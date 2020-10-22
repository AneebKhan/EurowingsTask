package com.maddbrains.eurowingstask.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import org.jetbrains.annotations.NotNull

@Parcelize
@Entity
data class Image(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @NotNull
    var id: String = "",

    var title: String? = null,
    var description: String? = null,
    var ups: Int? = null,
    var downs: Int? = null,
    var score: Int? = null,
    var imageUrl: String? = null
) : Parcelable