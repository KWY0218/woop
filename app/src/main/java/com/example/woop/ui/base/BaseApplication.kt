package com.example.woop.ui.base

import android.app.Application
import com.example.woop.BuildConfig

import com.example.woop.util.timber.WoopAppDebugTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(WoopAppDebugTree())
        }
    }
}