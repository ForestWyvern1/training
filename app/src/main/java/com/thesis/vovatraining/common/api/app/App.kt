package com.thesis.vovatraining.common.api.app

import android.app.Application
import com.thesis.vovatraining.common.api.data.DataManager

class App : Application() {
    companion object{
        lateinit var dm : DataManager
    }

    override fun onCreate() {
        super.onCreate()
        dm = DataManager(baseContext)
    }
}