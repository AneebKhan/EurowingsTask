package com.maddbrains.eurowingstask.data.api

import com.maddbrains.eurowingstask.BuildConfig
import com.maddbrains.eurowingstask.data.model.FeedResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImagesApi {
    @GET("gallery/{section}/{sort}/{window}/{page}")
    suspend fun getGalleryImages(
        @Path("section") section : String,
        @Path("sort") sort : String,
        @Path("window") window : String,
        @Path("page") page : String,
        @Query("showViral") showViral : Boolean,
        @Query("mature") showMature : Boolean,
        @Query("album_previews") albumPreview : Boolean
    ) : Response<FeedResponse>

    companion object {
        operator fun invoke(): ImagesApi {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getAuthorizationHeaderInterceptor())
                .build()
                .create(ImagesApi::class.java)
        }

        private fun getAuthorizationHeaderInterceptor(): OkHttpClient? {
            return OkHttpClient().newBuilder().addInterceptor { chain ->
                val originalRequest = chain.request()
                val builder = originalRequest.newBuilder().header(
                    "Authorization",
                    "Client-ID " + BuildConfig.CLIENT_ID
                )
                val newRequest = builder.build()
                chain.proceed(newRequest)
            }.build()
        }
    }

}