package com.example.watertracker.screen.fragment.statistic.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.watertracker.R

class StatisticItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val textViewDate: TextView
    val textViewAmount: TextView

    init {
        textViewDate = view.findViewById(R.id.text_view_date)
        textViewAmount = view.findViewById(R.id.text_view_amount)
    }
}