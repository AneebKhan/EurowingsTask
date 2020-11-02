package com.maddbrains.imgur.data.model

import com.google.gson.annotations.SerializedName

data class FeedResponse(

    @SerializedName("data")
    var data: List<ImageResponse>? = null,

    @SerializedName("success")
    var success: Boolean? = null,

    @SerializedName("status")
    var status: Int? = null
)