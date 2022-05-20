package com.pedro.prueba1_examen.ui.recyclerview

import android.os.Bundle
import android.view.*

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pedro.prueba1_examen.databinding.FragmentoCompuestoBinding


class Compuesta : Fragment() {

    private var _binding:FragmentoCompuestoBinding ? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(recyclerviewViewModel::class.java)

        _binding = FragmentoCompuestoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    

    }
    /***********************************************************/
