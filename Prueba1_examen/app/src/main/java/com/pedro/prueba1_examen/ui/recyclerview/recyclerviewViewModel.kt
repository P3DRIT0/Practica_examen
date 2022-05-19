package com.pedro.prueba1_examen.ui.recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class recyclerviewViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragmento de los Recyclerviws "
    }
    val text: LiveData<String> = _text
}