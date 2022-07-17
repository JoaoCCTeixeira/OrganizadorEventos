package pt.ipg.organizadoreventos.convidados

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import pt.ipg.organizadoreventos.R
import pt.ipg.organizadoreventos.databinding.FragmentEditarConvidadoBinding
import pt.ipg.organizadoreventos.databinding.FragmentMenuPrincipalBinding

class EditarConvidado : Fragment() {

    private var _binding: FragmentEditarConvidadoBinding? = null

    private val binding get() = _binding!!

    fun processaOpcaoMenu(item: MenuItem) : Boolean =
        when(item.itemId) {
            R.id.action_guardar -> {
                //guardar()
                true
            }
            R.id.action_cancelar -> {
                //voltaListaLivros()
                true
            }
            else -> false
        }

    companion object {
        fun newInstance() = EditarConvidado()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdicionarConvidado.setOnClickListener{
            var notBlanck = false
            var digitsOnly = false

            if (binding.editTextTextNomeConvidado.text.toString().isBlank()){
                binding.editTextTextNomeConvidado.error = "Preencha o campo com o nome do convidado"
                binding.editTextTextNomeConvidado.requestFocus()
            }
            if (!binding.editTextTextNomeConvidado.text.toString().isDigitsOnly()){
                binding.editTextTextNomeConvidado.error = "Preencha o campo com o nome do convidado"
                binding.editTextTextNomeConvidado.requestFocus()
            }


            if (binding.editTextTextNumeroConvidado.text.toString().isBlank()){
                binding.editTextTextNumeroConvidado.error = "Preencha o campo com o numero do convidado"
                binding.editTextTextNumeroConvidado.requestFocus()
            }
            if (binding.editTextTextNumeroConvidado.text.toString().isDigitsOnly()){
                binding.editTextTextNumeroConvidado.error = "Preencha o campo com o numero do convidado"
                binding.editTextTextNumeroConvidado.requestFocus()
            }


            if (binding.editTextTextCcConvidado.text.toString().isBlank()){
                binding.editTextTextCcConvidado.error = "Preencha o campo com o numero do cartão de cidadão do convidado"
                binding.editTextTextCcConvidado.requestFocus()
            }
            if (binding.editTextTextCcConvidado.text.toString().isDigitsOnly()){
                binding.editTextTextCcConvidado.error = "Preencha o campo com o numero do cartão de cidadão do convidado"
                binding.editTextTextNomeConvidado.requestFocus()
            }
        }

    }


    private lateinit var viewModel: EditarConvidadoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditarConvidadoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditarConvidadoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}