package com.example.newsapp.data.remote.dataTranferObject

import androidx.activity.result.IntentSenderRequest
import com.example.newsapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("evrything")
    suspend fun getNews(
        @Query("page")page: Int,
        @Query("sources") sources:String,
        @Query("apiKey")apiKey:String=API_KEY
    ): NewsResponse
}