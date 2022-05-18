package com.pedro.prueba1_examen.ui.slideshow

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pedro.prueba1_examen.R
import com.pedro.prueba1_examen.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Creando el adaptador desde un recurso
        val adapter = ArrayAdapter.createFromResource(
            requireContext(), R.array.formas_jorge, R.layout.item_guay
        ).apply { setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }

        binding.lista01
            .apply { this.adapter = adapter }
            .apply {
                setOnItemClickListener { _, view, _, _ ->
                    showNotification("Click en ${(view as TextView).text}")
                }
            }
            .apply {
                setOnItemLongClickListener { parent, view, position, id ->
                    showNotification(
                        """OnItemSelectedListener:
                            ${parent.selectedItem}
                            ${parent.getItemAtPosition(position)}
                            ${(view as TextView).text}
                            position = $position
                            id = $id
                            """.trimIndent()
                    )
                    true
                }
            }
    }

    private fun showNotification(mensaje: String) {
        AlertDialog.Builder(requireContext()).setMessage(mensaje).setTitle(R.string.dialog_title)
            .create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}