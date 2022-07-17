package pt.ipg.organizadoreventos.convidados

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pt.ipg.organizadoreventos.MainActivity
import pt.ipg.organizadoreventos.R
import pt.ipg.organizadoreventos.databinding.FragmentEditarConvidadoBinding
import pt.ipg.organizadoreventos.databinding.FragmentListarConvidadosBinding
import pt.ipg.organizadoreventos.databinding.FragmentMenuPrincipalBinding

class ListarConvidados : Fragment() {

    private var _binding: FragmentListarConvidadosBinding? = null

    private val binding get() = _binding!!


    companion object {
        fun newInstance() = ListarConvidados()
    }

    private lateinit var viewModel: ListarConvidadosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListarConvidadosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdicionarMaisConvidados.setOnClickListener{

            findNavController().navigate(R.id.action_listarConvidados_to_editarConvidado)
        }

        binding.buttonEliminarMaisConvidados.setOnClickListener{

            findNavController().navigate(R.id.action_listarConvidados_to_eliminarConvidado)
        }
    }




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListarConvidadosViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun processaOpcaoMenu(item: MenuItem) : Boolean =
        when(item.itemId) {
            R.id.action_inserir -> {
                //val acao = ListaLivrosFragmentDirections.actionListaLivrosToEditarLivro()
                //findNavController().navigate(acao)
                (activity as MainActivity).atualizaTitulo(R.string.Inserir_Convidado)
                true
            }
            R.id.action_alterar -> {
                //val acao = ListaLivrosFragmentDirections.actionListaLivrosToEditarLivro(livroSeleccionado)
                //findNavController().navigate(acao)
                (activity as MainActivity).atualizaTitulo(R.string.Alterar_Convidado)
                true
            }
            R.id.action_eliminar -> {
                //val acao = ListaLivrosFragmentDirections.actionListaLivrosFragmentToEliminarLivroFragment(livroSeleccionado!!)
                //findNavController().navigate(acao)
                true
            }
            else -> false
        }

}