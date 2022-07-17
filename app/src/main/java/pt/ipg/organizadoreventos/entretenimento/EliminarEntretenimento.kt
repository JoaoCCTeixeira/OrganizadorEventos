package pt.ipg.organizadoreventos.entretenimento

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pt.ipg.organizadoreventos.R

class EliminarEntretenimento : Fragment() {

    companion object {
        fun newInstance() = EliminarEntretenimento()
    }

    private lateinit var viewModel: EliminarEntretenimentoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_eliminar_entretenimento, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EliminarEntretenimentoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}