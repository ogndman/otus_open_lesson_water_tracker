package com.example.watertracker.screen.fragment.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.watertracker.data.WaterViewModel
import com.example.watertracker.databinding.FragmentAddWaterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddWaterFragment : Fragment() {

    private var _binding: FragmentAddWaterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WaterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddWaterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSave.setOnClickListener {
            val amount = binding.edittextAmount.text.toString().toIntOrNull() ?: 0
            viewModel.addWater(amount)

            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}