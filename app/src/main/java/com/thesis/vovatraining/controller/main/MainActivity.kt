package com.thesis.vovatraining.controller.main

import android.os.Bundle
import android.view.View
import com.thesis.vovatraining.common.base.activity.BaseActivity
import com.thesis.vovatraining.databinding.ActivityMainBinding

class MainActivity : BaseActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
    }
}