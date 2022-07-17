package pt.ipg.organizadoreventos.eventos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pt.ipg.organizadoreventos.R
import pt.ipg.organizadoreventos.databinding.FragmentListarEmpregadosBinding
import pt.ipg.organizadoreventos.databinding.FragmentListarEventosBinding

class ListarEventos : Fragment() {

    private var _binding: FragmentListarEventosBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ListarEventos()
    }

    private lateinit var viewModel: ListarEventosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListarEventosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdicionarMaisEventos.setOnClickListener{

            findNavController().navigate(R.id.action_listarEventos_to_editarEvento)
        }

        binding.buttonEliminarMaisEventos.setOnClickListener{

            findNavController().navigate(R.id.action_listarEventos_to_eliminarEvento)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListarEventosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}