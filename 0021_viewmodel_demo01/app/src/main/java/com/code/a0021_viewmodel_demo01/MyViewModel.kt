package com.code.a0021_viewmodel_demo01

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val _text: MutableLiveData<String> = MutableLiveData<String>("Hello #3")

    val text: LiveData<String>
        get() = _text

    fun setText(value: String) {
        _text.value = value
    }
}