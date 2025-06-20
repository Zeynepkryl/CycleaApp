package com.example.cycleaapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CycleaApp : Application() {
    override fun onCreate() {
        super.onCreate()

    }
}