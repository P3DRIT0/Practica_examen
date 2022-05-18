package com.pedro.prueba1_examen.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragmento de los spinners"
    }
    val text: LiveData<String> = _text
}