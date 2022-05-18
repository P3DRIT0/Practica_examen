package com.pedro.prueba1_examen.ui.gallery

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pedro.prueba1_examen.databinding.FragmentGalleryBinding
import java.lang.Exception

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
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

        binding.btnDesplazarse.setOnClickListener {
            Desplazarse()
        }
        binding.btnEnviar.setOnClickListener {

            val usuario = Usuario(
                binding.nombre.text.toString(),
                binding.edad.text.toString(),
                binding.spinner2.selectedItem.toString(),
                binding.spinner4.selectedItem.toString(),
            )
            /** Habría que gestionar errores en la inserción de datos, en particular
             * la NumberFormatException que salta si no se introduce un Int para la edad */


            findNavController().navigate(
                GalleryFragmentDirections.actionOrigenFragmentToDestinoFragment(usuario))
        }
    }
    private fun Desplazarse(){
        findNavController().navigate(when(binding.spinner.selectedItemPosition) {
            0 -> GalleryFragmentDirections.actionNavGalleryToNavAutocompletar()
            1 -> GalleryFragmentDirections.actionNavGalleryToNavSlideshow()
            else -> throw Exception("Vista inexistente")
        }
        )

    }

}
