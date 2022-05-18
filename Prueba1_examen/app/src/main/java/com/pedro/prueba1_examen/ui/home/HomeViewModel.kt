package com.pedro.prueba1_examen.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Seleccione una de las opciones"
    }
    val text: LiveData<String> = _text
}