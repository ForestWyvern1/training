package com.thesis.vovatraining.common.adapters.actuals

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thesis.vovatraining.R
import com.thesis.vovatraining.databinding.RvActualsMainBinding

class ActualsRvAdapter(
    private val context: Context,
    private val list: List<String>
) : RecyclerView.Adapter<ActualsRvAdapter.ViewHolder>() {

    private var currentPosition = 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) =
        ViewHolder(
            LayoutInflater
                .from(context)
                .inflate(
                    R.layout.rv_actuals_main,
                    parent,
                    false
                )
        )

    private lateinit var binding: RvActualsMainBinding

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        binding = RvActualsMainBinding.bind(holder.itemView)
        binding.textRvActuals.text = list[position]

        if (currentPosition == position) {
            binding.textRvActuals.setTextColor(context.getColor(R.color.colorPurpleText))
            binding.bottomLineRvActual.visibility = View.VISIBLE
        } else {
            binding.textRvActuals.setTextColor(context.getColor(R.color.colorGreyText))
            binding.bottomLineRvActual.visibility = View.GONE
        }

        binding.root.setOnClickListener {
            currentPosition = position

            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}