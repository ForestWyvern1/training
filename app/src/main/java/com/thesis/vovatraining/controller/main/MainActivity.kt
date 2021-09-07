package com.thesis.vovatraining.controller.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.thesis.vovatraining.common.adapters.actuals.ActualsRvAdapter
import com.thesis.vovatraining.common.adapters.genres.GenresRvAdapter
import com.thesis.vovatraining.common.api.app.App
import com.thesis.vovatraining.common.base.activity.BaseActivity
import com.thesis.vovatraining.common.case.Case
import com.thesis.vovatraining.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : BaseActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actualsRvMainActivity.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.actualsRvMainActivity.adapter = ActualsRvAdapter(this, listOf("Now Playing", "Popular", "Top Rated", "Upcoming"))

        binding.genresRvMainActivity.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val disp = App.dm.api
            .getGenres(Case.apiKey, Case.language)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({genres ->
                binding.genresRvMainActivity.adapter = GenresRvAdapter(this, genres.genres)
                binding.genresPbMain.visibility = View.GONE
                binding.genresRvMainActivity.visibility = View.VISIBLE
            }, {
                Toast.makeText(this, "Unfortunately this service is not responding", Toast.LENGTH_SHORT).show()
            })

    }
}