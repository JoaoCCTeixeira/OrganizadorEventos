package pt.ipg.organizadoreventos.entretenimento

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import pt.ipg.organizadoreventos.R
import pt.ipg.organizadoreventos.databinding.FragmentEditarConvidadoBinding
import pt.ipg.organizadoreventos.databinding.FragmentEditarEntretenimentoBinding

class EditarEntretenimento : Fragment() {

    private var _binding: FragmentEditarEntretenimentoBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = EditarEntretenimento()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdicionarEntretenimento.setOnClickListener{
            var notBlanck = false
            var digitsOnly = false

            if (binding.editTextTextTemaEntretenimento.text.toString().isBlank()){
                binding.editTextTextTemaEntretenimento.error = "Preencha o campo com o tema do entretenimento"
                binding.editTextTextTemaEntretenimento.requestFocus()
            }
            if (!binding.editTextTextTemaEntretenimento.text.toString().isDigitsOnly()){
                binding.editTextTextTemaEntretenimento.error = "Preencha o campo com o tema do entretenimento"
                binding.editTextTextTemaEntretenimento.requestFocus()
            }
        }

    }

    private lateinit var viewModel: EditarEntretenimentoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditarEntretenimentoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditarEntretenimentoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}