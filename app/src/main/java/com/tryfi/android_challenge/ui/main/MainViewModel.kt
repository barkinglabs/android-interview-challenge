package com.tryfi.android_challenge.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _isPlaying: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val isPlaying: LiveData<Boolean> = _isPlaying

    private val _progress: MutableLiveData<Int> = MutableLiveData<Int>()
    val progress: LiveData<Int> = _progress

    init {
        _isPlaying.value = false
        _progress.value = 10
    }

    fun toggleIsPlaying() {

    }

    fun setProgress(value: Int) {

    }

}