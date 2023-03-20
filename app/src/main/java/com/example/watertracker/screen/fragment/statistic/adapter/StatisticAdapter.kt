package com.example.watertracker.screen.fragment.statistic.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.watertracker.R
import com.example.watertracker.data.source.database.WaterEntity

class StatisticAdapter :
    RecyclerView.Adapter<StatisticItemViewHolder>() {

    private val list: MutableList<WaterEntity> = mutableListOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): StatisticItemViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_statistic, viewGroup, false)

        return StatisticItemViewHolder(view)
    }

    override fun onBindViewHolder(statisticItemViewHolder: StatisticItemViewHolder, position: Int) {
        val item = list[position]
        statisticItemViewHolder.textViewAmount.text = item.amount.toString()
        statisticItemViewHolder.textViewDate.text = item.createdDate
    }

    override fun getItemCount() = list.size

    fun setData(items: List<WaterEntity>) {
        list.clear()
        list.addAll(items)
        notifyItemInserted(0)
    }
}