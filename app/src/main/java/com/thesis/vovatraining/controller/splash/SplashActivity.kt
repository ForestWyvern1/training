package com.thesis.vovatraining.controller.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.thesis.vovatraining.common.base.activity.BaseActivity
import com.thesis.vovatraining.controller.main.MainActivity
import com.thesis.vovatraining.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun handler() {
        Handler().postDelayed({startActivityWithFinish(MainActivity::class.java)}, 2000)
    }
}