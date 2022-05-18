package com.pedro.prueba1_examen.ui.gallery


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Usuario(private val nombre: String?, private val edad: String?, private val provincia: String?,private val ciudad: String?) : Parcelable {

    override fun toString() = "Se ha recibido al usuario $nombre con $edad años, de $provincia-$ciudad"

}