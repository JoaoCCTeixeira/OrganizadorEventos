package pt.ipg.organizadoreventos.empregados

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pt.ipg.organizadoreventos.R

class EliminarEmpregado : Fragment() {

    companion object {
        fun newInstance() = EliminarEmpregado()
    }

    private lateinit var viewModel: EliminarEmpregadoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_eliminar_empregado, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EliminarEmpregadoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}