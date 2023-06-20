package com.tryfi.android_challenge.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var _playJob: Job? = null
    private var _frameCount = 0
    private var _speed = 1f

    private val _isPlaying: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val isPlaying: LiveData<Boolean> = _isPlaying

    private val _currentFrame: MutableLiveData<Int> = MutableLiveData<Int>()
    val currentFrame: LiveData<Int> = _currentFrame

    init {
        _isPlaying.value = false
        _currentFrame.value = 10
    }

    fun setNumberOfFrames(nFrames: Int) {
        _frameCount = nFrames
    }
    private fun play() {
        _isPlaying.value = true
        _playJob = viewModelScope.launch {
            while (isActive) {
                val lastFrameIndex = _currentFrame.value ?: 0
                val nextFrameIndex = (lastFrameIndex + 1).takeIf { it < _frameCount } ?: 0

                _currentFrame.postValue(nextFrameIndex)
                delay(40L)
            }
        }
    }

    private fun pause() {
        _isPlaying.value = false
        _playJob?.cancel()
    }
    fun toggleIsPlaying() {}

    fun setCurrentFrame(value: Int) {}

    fun setSpeed(speed: Float) {}

}