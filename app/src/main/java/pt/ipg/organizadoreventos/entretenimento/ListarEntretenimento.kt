package pt.ipg.organizadoreventos.entretenimento

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pt.ipg.organizadoreventos.R
import pt.ipg.organizadoreventos.databinding.FragmentListarEmpregadosBinding
import pt.ipg.organizadoreventos.databinding.FragmentListarEntretenimentoBinding

class ListarEntretenimento : Fragment() {

    private var _binding: FragmentListarEntretenimentoBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ListarEntretenimento()
    }

    private lateinit var viewModel: ListarEntretenimentoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListarEntretenimentoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdicionarMaisEntretenimento.setOnClickListener{

            findNavController().navigate(R.id.action_listarEntretenimento_to_editarEntretenimento)
        }

        binding.buttonEliminarMaisEntretenimento.setOnClickListener{

            findNavController().navigate(R.id.action_listarEntretenimento_to_eliminarEntretenimento)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListarEntretenimentoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}