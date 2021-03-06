package com.pedro.prueba1_examen.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pedro.prueba1_examen.databinding.FragmentHomeBinding
import com.pedro.prueba1_examen.ui.recyclerview.reclyclerviewFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    /***********************************************************/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSpinners.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionNavHomeToNavGallery())
        }

        binding.autocompletar.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionNavHomeToNavAutocompletar())
        }

        binding.listviews.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionNavHomeToNavSlideshow())
        }
        binding.RecyclerView.setOnClickListener{
            findNavController().navigate(HomeFragmentDirections.actionNavHomeToNavRecyclerview())
        }
    }
}