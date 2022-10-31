package com.tematihonov.animation.presentation.slot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tematihonov.animation.R
import com.tematihonov.animation.databinding.FragmentSlotBinding
import kotlin.random.Random

class SlotFragment : Fragment() {

    private var _binding: FragmentSlotBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: SlotAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSlotBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var arr1: Array<Int> = Array(300) { Random.nextInt(0, 8) }
        var arr2: Array<Int> = Array(300) { Random.nextInt(0, 8) }
        var arr3: Array<Int> = Array(300) { Random.nextInt(0, 8) }
        var arr4: Array<Int> = Array(300) { Random.nextInt(0, 8) }
        var arr5: Array<Int> = Array(300) { Random.nextInt(0, 8) }
        binding.rv1.layoutManager = LinearLayoutManager(this.context)
        adapter = SlotAdapter(arr1.toList())
        binding.rv1.adapter = adapter
        var spinsize = 0
        binding.spinButton.setOnClickListener {
            spinsize += Random.nextInt(10, 30)
            binding.rv1.smoothScrollToPosition(spinsize)
        }




    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}