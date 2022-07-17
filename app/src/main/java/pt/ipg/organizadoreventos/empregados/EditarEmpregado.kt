package pt.ipg.organizadoreventos.empregados

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import pt.ipg.organizadoreventos.R
import pt.ipg.organizadoreventos.convidados.EditarConvidadoViewModel
import pt.ipg.organizadoreventos.databinding.FragmentEditarConvidadoBinding
import pt.ipg.organizadoreventos.databinding.FragmentEditarEmpregadoBinding

class EditarEmpregado : Fragment() {

    private var _binding: FragmentEditarEmpregadoBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = EditarEmpregado()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdicionarEmpregado.setOnClickListener{
            var notBlanck = false
            var digitsOnly = false

            if (binding.editTextTextNomeEmpregado.text.toString().isBlank()){
                binding.editTextTextNomeEmpregado.error = "Preencha o campo com o nome do empregado"
                binding.editTextTextNomeEmpregado.requestFocus()
            }
            if (!binding.editTextTextNomeEmpregado.text.toString().isDigitsOnly()){
                binding.editTextTextNomeEmpregado.error = "Preencha o campo com o nome do empregado"
                binding.editTextTextNomeEmpregado.requestFocus()
            }


            if (binding.editTextTextNumeroEmpregado.text.toString().isBlank()){
                binding.editTextTextNumeroEmpregado.error = "Preencha o campo com o numero do empregado"
                binding.editTextTextNumeroEmpregado.requestFocus()
            }
            if (binding.editTextTextNumeroEmpregado.text.toString().isDigitsOnly()){
                binding.editTextTextNumeroEmpregado.error = "Preencha o campo com o numero do empregado"
                binding.editTextTextNumeroEmpregado.requestFocus()
            }

            if (binding.editTextTextGmailEmpregado.text.toString().isBlank()){
                binding.editTextTextGmailEmpregado.error = "Preencha o campo com o gmail do empregado"
                binding.editTextTextGmailEmpregado.requestFocus()
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(binding.editTextTextGmailEmpregado.text.toString()).matches()){
                binding.editTextTextGmailEmpregado.error = "Preencha o campo com o gmail do empregado"
                binding.editTextTextGmailEmpregado.requestFocus()
            }


            if (binding.editTextTextCcEmpregado.text.toString().isBlank()){
                binding.editTextTextCcEmpregado.error = "Preencha o campo com o numero do cartão de cidadão do empregado"
                binding.editTextTextCcEmpregado.requestFocus()
            }
            if (binding.editTextTextCcEmpregado.text.toString().isDigitsOnly()){
                binding.editTextTextCcEmpregado.error = "Preencha o campo com o numero do cartão de cidadão do empregado"
                binding.editTextTextNomeEmpregado.requestFocus()
            }
        }

    }
    private lateinit var viewModel: EditarEmpregadoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditarEmpregadoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditarEmpregadoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}