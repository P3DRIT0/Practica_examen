package com.pedro.prueba1_examen.ui.gallery

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.pedro.prueba1_examen.databinding.FragmentDestinoBinding


class DestinoFragment : Fragment() {
    private var _binding: FragmentDestinoBinding? = null
    private val binding get() = _binding!!

    /** navArgs devuelve un Lazy delegate para acceder a los argumentos recividos por el Fragment */
    private val args: DestinoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDestinoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvRecepcion.text = args.usuario.toString()

    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}

