package pt.ipg.organizadoreventos.eventos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import androidx.core.view.get
import androidx.navigation.fragment.findNavController
import pt.ipg.organizadoreventos.R
import pt.ipg.organizadoreventos.databinding.FragmentEditarConvidadoBinding
import pt.ipg.organizadoreventos.databinding.FragmentEditarEmpregadoBinding
import pt.ipg.organizadoreventos.databinding.FragmentEditarEventoBinding
import java.time.DayOfWeek
import java.util.*

class EditarEvento : Fragment() {

    private var _binding: FragmentEditarEventoBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = EditarEvento()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdicionarEvento.setOnClickListener{
            var verificar1 = false
            var verificar2 = false
            var verificar3 = false
            var verificar4 = false
            var verificar5 = false

            var dia = binding.buttonData.dayOfMonth
            var mes = binding.buttonData.month
            var ano = binding.buttonData.year


            if (binding.editTextTextPrecoEvento.text.toString().isBlank()){
                binding.editTextTextPrecoEvento.error = "Preencha o campo com o preco do evento"
                binding.editTextTextPrecoEvento.requestFocus()
                verificar1 = false
            }else{
                verificar1 = true
            }


            if (binding.editTextTextPrecoEvento.text.toString().isDigitsOnly()){
                binding.editTextTextPrecoEvento.error = "Preencha o campo com o preco do evento"
                binding.editTextTextPrecoEvento.requestFocus()
                verificar2 = false
            }else{
            verificar2 = true
        }

            if (binding.editTextTextLocalizacaoEvento.text.toString().isBlank()){
                binding.editTextTextLocalizacaoEvento.error = "Preencha o campo com a localização do evento"
                binding.editTextTextLocalizacaoEvento.requestFocus()
                verificar3 = false
            }else{
                verificar3 = true
            }

            if (binding.editTextTextNomeEvento.text.toString().isBlank()){
                binding.editTextTextNomeEvento.error = "Preencha o campo com o nome do evento"
                binding.editTextTextNomeEvento.requestFocus()
                verificar4 = false
            }else{
                verificar4 = true
            }
            if (binding.editTextTextNomeEvento.text.toString().isDigitsOnly()){
                binding.editTextTextNomeEvento.error = "Preencha o campo com o nome do evento"
                binding.editTextTextNomeEvento.requestFocus()
                verificar5 = false
            }else{
                verificar5 = true
            }

            if(verificar1 && verificar2 && verificar3 && verificar4 && verificar5){
                binding.buttonAdicionarEvento.setOnClickListener{
                    findNavController().navigate(R.id.action_editarEvento_to_menuPrincipal)
                }
            }

        }

    }

    private lateinit var viewModel: EditarEventoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditarEventoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditarEventoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}