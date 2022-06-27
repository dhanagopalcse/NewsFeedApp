package com.dhana.newsfeedapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsFeedApp : Application(){

    override fun onCreate() {
        super.onCreate()
    }


}