/*
 * *
 *  * Created by Rafsan Ahmad on 1/7/22, 12:09 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *
 */

package com.dhana.newsfeedapp.di

import android.content.Context
import com.dhana.newsfeedapp.NewsFeedApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): NewsFeedApp {
        return app as NewsFeedApp
    }

}