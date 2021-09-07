package com.thesis.vovatraining.common.adapters.genres

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.thesis.vovatraining.R
import com.thesis.vovatraining.databinding.RvGenresMainBinding
import com.thesis.vovatraining.model.genres.Genres

class GenresRvAdapter(private val context: Context, private val list: List<Genres>) : RecyclerView.Adapter<GenresRvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater
                .from(context)
                .inflate(R.layout.rv_genres_main, parent, false)
        )

    private lateinit var binding: RvGenresMainBinding

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding = RvGenresMainBinding.bind(holder.itemView)
        binding.genreTitle.text = list[position].name

        binding.genreButton.setOnClickListener {
            Toast.makeText(context, list[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}