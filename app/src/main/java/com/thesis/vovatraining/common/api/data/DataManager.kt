package com.thesis.vovatraining.common.api.data

import android.content.Context
import android.content.SharedPreferences

class DataManager(baseContext: Context) {

    private var shared: SharedPreferences =
        baseContext.getSharedPreferences("ws", Context.MODE_PRIVATE)

    val api = Api.createApi()
}