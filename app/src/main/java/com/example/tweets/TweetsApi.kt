package com.example.tweets

import com.example.tweets.models.Tweets
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsApi {
    @GET("/v3/b/6610427aacd3cb34a833f638?meta=false")
    suspend fun getTweets(@Header("X-Master-Key") category: String): Response<List<Tweets>>

    @GET("/v3/b/6610427aacd3cb34a833f638?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories(): Response<List<String>>
}