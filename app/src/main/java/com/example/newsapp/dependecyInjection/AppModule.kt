package com.example.newsapp.dependecyInjection

import android.app.Application
import com.example.newsapp.data.manager.LocalUserImplementation
import com.example.newsapp.domain.manager.LocalUserManager
import com.example.newsapp.domain.usecases.app_entry.AppEntryUsecases
import com.example.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.example.newsapp.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application:Application
    ): LocalUserManager= LocalUserImplementation(application)



    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    )= AppEntryUsecases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}