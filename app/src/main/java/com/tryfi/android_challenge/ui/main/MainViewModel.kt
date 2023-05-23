package com.tryfi.android_challenge.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val isPlaying: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val progress: MutableLiveData<Int> = MutableLiveData<Int>()

    init {
        isPlaying.value = false
        progress.value = 10
    }

    fun toggleIsPlaying() {

    }

    fun setProgress(value: Int) {

    }

}