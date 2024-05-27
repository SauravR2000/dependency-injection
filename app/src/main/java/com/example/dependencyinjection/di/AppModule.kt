package com.example.dependencyinjection.di

import android.app.Application
import com.example.dependencyinjection.data.remote.MyApi
import com.example.dependencyinjection.data.repository.MyRepositoryImpl
import com.example.dependencyinjection.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyApi(): MyApi {
        return Retrofit
            .Builder()
            .baseUrl("https://google.com/")
            .build()
            .create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(
        api: MyApi,
        app: Application,
        @Named("hello2") hello: String
    ): MyRepository {
        return MyRepositoryImpl(api, app, hello)
    }

    @Provides
    @Singleton
    @Named("hello1")
    fun provideString1() = "Hello 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun provideString2() = "Hello 2"
}