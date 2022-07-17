package pt.ipg.organizadoreventos.empregados

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pt.ipg.organizadoreventos.R
import pt.ipg.organizadoreventos.databinding.FragmentListarConvidadosBinding
import pt.ipg.organizadoreventos.databinding.FragmentListarEmpregadosBinding

class ListarEmpregados : Fragment() {

    private var _binding: FragmentListarEmpregadosBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ListarEmpregados()
    }

    private lateinit var viewModel: ListarEmpregadosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListarEmpregadosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdicionarMaisEmpregados.setOnClickListener{

            findNavController().navigate(R.id.action_listarEmpregados_to_editarEmpregado)
        }

        binding.buttonEliminarMaisEmpregados.setOnClickListener{

            findNavController().navigate(R.id.action_listarEmpregados_to_eliminarEmpregado)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListarEmpregadosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}