package com.tematihonov.animation.presentation.fortuneWheel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.tematihonov.animation.databinding.FragmentWheelBinding

class FortuneWheelFragment : Fragment() {

    private var _binding: FragmentWheelBinding? = null
    private val binding get() = _binding!!
    private val vm = FortuneWheelViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWheelBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.lastWin.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Your win is $it", Toast.LENGTH_SHORT).show()

        }
        var count = 0
        count += vm.getRandomRotationCount()

        val index = (vm.currentSegment + count) % FortuneWheelViewModel.SEGMENTS
        var startDegrees = vm.currentSegment * FortuneWheelViewModel.SEGMENT_DEGREES
        val animation: RotateAnimation = RotateAnimation(
            startDegrees,
            (vm.currentSegment + count) * FortuneWheelViewModel.SEGMENT_DEGREES,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        ).apply {
            interpolator = AccelerateDecelerateInterpolator()
            this.duration = 3000L
            fillAfter = true
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    vm.currentSegment = index
                    startDegrees = vm.currentSegment * FortuneWheelViewModel.SEGMENT_DEGREES
                    vm.winSize(index)
                }

                override fun onAnimationRepeat(p0: Animation?) {
                }
            })
        }


        binding.spinButton.setOnClickListener {
            binding.fortuneWheel.startAnimation(animation)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}