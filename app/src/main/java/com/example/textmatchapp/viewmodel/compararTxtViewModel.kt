package com.example.textmatchapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.textmatchapp.model.CompararTxt

class CompararTextViewModel : ViewModel() {

    private val _compareResult = MutableLiveData<String>()
    val compareResult: LiveData<String>
        get() = _compareResult

    fun compareText(text1: String, text2: String) {
        val model = CompararTxt(text1, text2)
        _compareResult.value = if (model.sonIguales()) {
            "Los textos son iguales"
        } else {
            "Los textos son diferentes"
        }
    }
}

