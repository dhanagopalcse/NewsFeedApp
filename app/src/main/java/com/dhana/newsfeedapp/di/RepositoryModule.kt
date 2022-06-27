package com.dhana.newsfeedapp.di

import android.content.Context
import com.dhana.newsfeedapp.data.local.NewsDao
import com.dhana.newsfeedapp.data.local.NewsDatabase
import com.dhana.newsfeedapp.network.api.ApiHelper
import com.dhana.newsfeedapp.repository.INewsRepository
import com.dhana.newsfeedapp.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        NewsDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideNewsDao(db: NewsDatabase) = db.getNewsDao()

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: ApiHelper,
        localDataSource: NewsDao
    ) = NewsRepository(remoteDataSource, localDataSource)

    @Singleton
    @Provides
    fun provideINewsRepository(repository: NewsRepository): INewsRepository = repository
}