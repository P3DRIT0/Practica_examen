package com.pedro.prueba1_examen.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragmento de los Listviews"
    }
    val text: LiveData<String> = _text
}