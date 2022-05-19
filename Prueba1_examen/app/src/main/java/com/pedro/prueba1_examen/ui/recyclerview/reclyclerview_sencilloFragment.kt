package com.pedro.prueba1_examen.ui.recyclerview

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pedro.prueba1_examen.R
import com.pedro.prueba1_examen.databinding.Elemento3Binding
import com.pedro.prueba1_examen.databinding.FragmentRecyclersencilloBinding
import com.pedro.prueba1_examen.databinding.FragmentRecyclerviewBinding


class reclyclerview_sencilloFragment : Fragment() {
    private var _binding: FragmentRecyclersencilloBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentRecyclersencilloBinding.inflate(inflater, container, false)

        val lenguajes: MutableList<Jorges> = ArrayList()
        lenguajes.add(Jorges("Jorge Fontanero", R.mipmap.ic_georgefontanero))
        lenguajes.add(Jorges("Jorge Piscinita", R.mipmap.ic_piscinitageorge))
        lenguajes.add(Jorges("Jorge Con Jordi", R.mipmap.ic_georgecongordi))
        lenguajes.add(Jorges("Jorge Modo Secso", R.mipmap.ic_georgemodosecso))
        lenguajes.add(Jorges("Jorge cuando hablas de su novia", R.mipmap.ic_georgeceloso))
        lenguajes.add(Jorges("Jorge Calvito", R.mipmap.ic_georgecalvito))
        with(binding.recyclerview) {
            adapter = Custom3Adapter(lenguajes)
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    class Custom3Adapter(private val listadoDatos: MutableList<Jorges>) :
        RecyclerView.Adapter<Custom3Adapter.ViewHolder>() {

        /** Clase que describe la vista de cada elemento de la lista y su posición en esta. */
        class ViewHolder(binding: Elemento3Binding) : RecyclerView.ViewHolder(binding.root) {
            val mView = binding.root
            val textView = binding.textView
            val imageView = binding.imageView

            init {
                binding.root.setOnClickListener {
                    Toast.makeText(
                        binding.root.context,
                        "Has elegido: " + textView.text,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }

        /** Método al que se llama cada vez que se crea uno de los elementos de la lista. */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            Elemento3Binding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )


        /** Método que vincula en cada elemento, según su posición, los datos correspondientes a
         * cada elemento */
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = listadoDatos[position].nombre
            holder.imageView.setImageResource(listadoDatos[position].idImagen)

            with(holder) {
                if (position % 2 == 0) { // Si la posición de la fila es par
                    mView.setBackgroundColor(Color.CYAN)
                    textView.setTextColor(Color.BLUE)
                } else { // Si la posición es impar
                    mView.setBackgroundColor(Color.TRANSPARENT)
                    textView.setTextColor(Color.BLUE)
                }
            }
        }

        override fun getItemCount() = listadoDatos.size

    }
}


    /***********************************************************/
