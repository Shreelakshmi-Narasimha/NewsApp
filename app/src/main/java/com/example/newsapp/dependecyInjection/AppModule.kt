package com.example.newsapp.dependecyInjection

import android.app.Application
import com.example.newsapp.data.manager.LocalUserImplementation
import com.example.newsapp.data.remote.dataTranferObject.NewsApi
import com.example.newsapp.data.repository.NewsRepositoryImp
import com.example.newsapp.domain.manager.LocalUserManager
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.domain.usecases.app_entry.AppEntryUsecases
import com.example.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.example.newsapp.domain.usecases.app_entry.SaveAppEntry
import com.example.newsapp.domain.usecases.news.GetNews
import com.example.newsapp.domain.usecases.news.NewsUseCases
import com.example.newsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository= NewsRepositoryImp(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository: NewsRepository): NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }
}