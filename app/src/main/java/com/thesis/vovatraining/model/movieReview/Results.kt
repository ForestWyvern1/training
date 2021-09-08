package com.thesis.vovatraining.model.movieReview

data class Results(
    val poster_path: String,
    val original_title: String,
    val vote_average: String,
    val genre_ids: List<Int>,
    val id: Int
)