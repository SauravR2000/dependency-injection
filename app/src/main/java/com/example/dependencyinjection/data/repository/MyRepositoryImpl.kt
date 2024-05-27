package com.example.dependencyinjection.data.repository

import android.app.Application
import com.example.dependencyinjection.R
import com.example.dependencyinjection.data.remote.MyApi
import com.example.dependencyinjection.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl(
    private val api: MyApi,
    private val appContext: Application,
    private val stringVal: String,
) : MyRepository {


    init {
        val appName = appContext.getString(R.string.app_name)
        println("the app name = $appName")
        println("the greeting = $stringVal")
    }

    override suspend fun doNetworkcall() {
        println("my repo called here")
    }
}