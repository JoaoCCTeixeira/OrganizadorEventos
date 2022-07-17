package pt.ipg.organizadoreventos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pt.ipg.organizadoreventos.databinding.FragmentMenuPrincipalBinding

class MenuPrincipal : Fragment() {

    private var _binding: FragmentMenuPrincipalBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: MenuPrincipalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuPrincipalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonConvidadosMenu.setOnClickListener {
            findNavController().navigate(R.id.action_menuPrincipal_to_listarConvidados)
        }

        binding.buttonEmpregadosMenu.setOnClickListener {
            findNavController().navigate(R.id.action_menuPrincipal_to_listarEmpregados)
        }

        binding.buttonEventosMenu.setOnClickListener {
            findNavController().navigate(R.id.action_menuPrincipal_to_listarEventos)
        }

        binding.buttonEntretenimentoMenu.setOnClickListener {
            findNavController().navigate(R.id.action_menuPrincipal_to_listarEntretenimento)
        }

        val activity = activity as MainActivity

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun processaOpcaoMenu(item: MenuItem) : Boolean =
        when(item.itemId) {
            R.id.action_settings -> true
            else -> false
        }

}