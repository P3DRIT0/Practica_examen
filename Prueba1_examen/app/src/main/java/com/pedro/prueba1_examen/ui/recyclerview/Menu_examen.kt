package com.pedro.prueba1_examen.ui.recyclerview

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pedro.prueba1_examen.R
import com.pedro.prueba1_examen.databinding.FragmentMenuexBinding


class Menu_examen : Fragment() {

    private var _binding: FragmentMenuexBinding? = null

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

        _binding = FragmentMenuexBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)

        when(item.itemId){
            R.id.simple->findNavController().navigate(Menu_examenDirections.actionMenuExamenToSimple2())
            R.id.compuesta->findNavController().navigate(Menu_examenDirections.actionMenuExamenToSimple2())
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(Menu_examenDirections.actionMenuExamenToSimple2())
        }
        }
    }




    /***********************************************************/
