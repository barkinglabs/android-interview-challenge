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

    private val _progress: MutableLiveData<Int> = MutableLiveData<Int>()
    val progress: LiveData<Int> = _progress

    init {
        _isPlaying.value = false
        _progress.value = 10
    }

    fun setNumberOfFrames(nFrames: Int) {
        _frameCount = nFrames
    }
    private fun play() {
        _isPlaying.value = true
        _playJob = viewModelScope.launch {
            while (isActive) {
                val lastFrameIndex = _progress.value ?: 0
                val nextFrameIndex = (lastFrameIndex + 1).takeIf { it < _frameCount } ?: 0

                _progress.postValue(nextFrameIndex)
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