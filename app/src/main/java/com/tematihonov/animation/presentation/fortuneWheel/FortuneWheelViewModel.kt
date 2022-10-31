package com.tematihonov.animation.presentation.fortuneWheel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class FortuneWheelViewModel : ViewModel() {

    private val _lastWin = MutableLiveData(0)
    val lastWin: LiveData<Int>
        get() = _lastWin

    var currentSegment: Int = 0

    fun getRandomRotationCount(): Int {
        return SEGMENTS * 2 + Random.nextInt(SEGMENTS * 5)
    }

    fun winSize(index: Int) {
        check(index >= 0 && index < BENEFITS.size) { "Index $index out of bounds" }
        _lastWin.value = BENEFITS[index]
    }

    companion object {
        const val SEGMENTS = 16
        const val SEGMENT_DEGREES = 360f / SEGMENTS
        private val BENEFITS =
            listOf(500, 100, 80, 200, 800, 100, 320, 400, 60, 350, 700, 50, 120, 160, 900, 550)
    }
}