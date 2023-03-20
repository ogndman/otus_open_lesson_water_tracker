package com.example.watertracker.screen.fragment.statistic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.watertracker.data.WaterViewModel
import com.example.watertracker.databinding.FragmentStatisticBinding
import com.example.watertracker.screen.fragment.statistic.adapter.StatisticAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticFragment : Fragment() {

    private var _binding: FragmentStatisticBinding? = null
    private val binding get() = _binding!!

    private val statisticAdapter = StatisticAdapter()
    private val viewModel: WaterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatisticBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.statisticRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = statisticAdapter
        }
        viewModel.allPortions.observe(viewLifecycleOwner) {
            statisticAdapter.setData(it)
        }

        viewModel.getAllPortions()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}