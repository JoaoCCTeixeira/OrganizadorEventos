package pt.ipg.organizadoreventos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pt.ipg.organizadoreventos.databinding.FragmentListarEmpregadosBinding
import pt.ipg.organizadoreventos.databinding.FragmentListarEventosBinding
import pt.ipg.organizadoreventos.databinding.FragmentMenuInicialBinding

class MenuInicial : Fragment() {

    private var _binding: FragmentMenuInicialBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MenuInicial()
    }

    private lateinit var viewModel: MenuInicialViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuInicialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonVerEventos.setOnClickListener{

            findNavController().navigate(R.id.action_menuInicial_to_listarEventos)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuInicialViewModel::class.java)
        // TODO: Use the ViewModel
    }

}