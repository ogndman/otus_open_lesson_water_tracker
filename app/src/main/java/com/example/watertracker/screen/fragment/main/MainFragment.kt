package com.example.watertracker.screen.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.watertracker.R
import com.example.watertracker.data.WaterViewModel
import com.example.watertracker.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WaterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdd.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.buttonStatistic.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_ListFragment)
        }

        viewModel.totalAmount.observe(viewLifecycleOwner) {
            binding.textViewAmount.text = "$it мл"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}