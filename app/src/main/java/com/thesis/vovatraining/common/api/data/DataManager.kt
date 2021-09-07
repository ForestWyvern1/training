package com.thesis.vovatraining.common.api.data

import android.content.Context
import android.content.SharedPreferences

class DataManager {
    private var shared: SharedPreferences
    private var baseContext : Context

    val api = Api.createApi()

    constructor(baseContext: Context){
        this.baseContext = baseContext
        shared = baseContext.getSharedPreferences("ws", Context.MODE_PRIVATE)
    }
}