package com.tematihonov.animation.presentation.flipCard

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tematihonov.animation.R
import com.tematihonov.animation.databinding.FragmentCardFlipBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class CardFlipFragment: Fragment() {

    private var _binding: FragmentCardFlipBinding? = null
    private val binding get() = _binding!!
    lateinit var front_anim: AnimatorSet
    lateinit var back_anim: AnimatorSet
    var isFront = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardFlipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scale: Float = requireContext().resources.displayMetrics.density
        binding.cardFront.cameraDistance = 8000 * scale
        binding.cardBack.cameraDistance = 8000 * scale

        front_anim = AnimatorInflater.loadAnimator(context, R.animator.front_animator) as AnimatorSet
        back_anim = AnimatorInflater.loadAnimator(context, R.animator.back_animator) as AnimatorSet

        binding.apply {
            flipBtn.setOnClickListener{
                if (isFront) {
                    front_anim.setTarget(cardFront)
                    back_anim.setTarget(cardBack)
                    front_anim.start()
                    back_anim.start()
                    isFront = false
                } else {
                    front_anim.setTarget(cardBack)
                    back_anim.setTarget(cardFront)
                    back_anim.start()
                    front_anim.start()
                    isFront = true
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}