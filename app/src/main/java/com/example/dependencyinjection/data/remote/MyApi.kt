package com.example.dependencyinjection.data.remote

import retrofit2.http.GET

interface MyApi {
    @GET("test")
    suspend fun getCall()
}