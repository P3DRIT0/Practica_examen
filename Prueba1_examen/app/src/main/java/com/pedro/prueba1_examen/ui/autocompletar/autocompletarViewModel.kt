package com.pedro.prueba1_examen.ui.autocompletar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class autocompletarViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragmento de autocompletar"
    }
    val text: LiveData<String> = _text
}