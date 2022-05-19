package com.pedro.prueba1_examen.ui.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pedro.prueba1_examen.databinding.FragmentRecyclerviewBinding


class reclyclerviewFragment : Fragment() {

    private var _binding: FragmentRecyclerviewBinding? = null

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

        _binding = FragmentRecyclerviewBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textRecycler
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    binding.btnRecycler.setOnClickListener {
        findNavController().navigate(reclyclerviewFragmentDirections.actionNavRecyclerviewToReclyclerviewSencilloFragment())
    }
    }

    }
    /***********************************************************/
