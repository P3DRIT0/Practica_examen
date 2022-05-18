package com.pedro.prueba1_examen.ui.autocompletar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pedro.prueba1_examen.R
import com.pedro.prueba1_examen.databinding.FragmentAutocompletarBinding

class autocompletarFragment : Fragment() {

    private var _binding: FragmentAutocompletarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val autocompletarViewModel =
            ViewModelProvider(this).get(autocompletarViewModel::class.java)

        _binding = FragmentAutocompletarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAutocompletar
        autocompletarViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }


    /***********************************************************/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.comunidades) {
            setAdapter(
                ArrayAdapter.createFromResource(
                    requireContext(), R.array.comunidades_autonomas,
                    android.R.layout.simple_spinner_item
                )
            )

        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}