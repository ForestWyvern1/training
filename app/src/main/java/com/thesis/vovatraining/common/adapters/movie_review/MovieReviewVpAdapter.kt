package com.thesis.vovatraining.common.adapters.movie_review

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thesis.vovatraining.R
import com.thesis.vovatraining.common.case.Case
import com.thesis.vovatraining.databinding.VpMovieReviewMainBinding
import com.thesis.vovatraining.model.movieReview.Results
import java.util.*

class MovieReviewVpAdapter(
    private val context: Context,
    private val list: List<Results>
) : RecyclerView.Adapter<MovieReviewVpAdapter.ViewHolder>() {

    private lateinit var binding: VpMovieReviewMainBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(context).inflate(
            R.layout.vp_movie_review_main, parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding = VpMovieReviewMainBinding.bind(holder.itemView)
        val item = list[position]

        binding.movieReviewText.text = item.original_title

        val voteAverage = item.vote_average
        binding.movieRateText.text =
            if (voteAverage.contains("."))
                voteAverage
            else
                String.format(
                    Locale.getDefault(),
                    "%s.0",
                    voteAverage
                )
//        binding.movieRateText.text =
//            String.format(
//                Locale.getDefault(),
//                "%.5f",
//                voteAverage
//            )
        Glide
            .with(context)
            .load(
                String.format(
                    Locale.getDefault(),
                    "%s%s",
                    Case.imageUrl,
                    item.poster_path
                )
            )
            .into(binding.movieReviewPoster)
    }

    override fun getItemCount() = list.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}