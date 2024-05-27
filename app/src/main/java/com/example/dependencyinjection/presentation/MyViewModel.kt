package com.example.dependencyinjection.presentation

import androidx.lifecycle.ViewModel
import com.example.dependencyinjection.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {
    init {
        GlobalScope.launch {
            c()

        }
    }


    suspend fun c() {
        println("the repo = ${repository.doNetworkcall()}")

    }
}