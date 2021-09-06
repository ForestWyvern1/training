package com.thesis.vovatraining.common.base.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun startActivityWithFinish(activityClass: Class<*>){
        startActivity(Intent(applicationContext, activityClass))
        finish()
    }

    fun startActivity(activityClass: Class<*>){
        startActivity(Intent(applicationContext, activityClass))
    }

}