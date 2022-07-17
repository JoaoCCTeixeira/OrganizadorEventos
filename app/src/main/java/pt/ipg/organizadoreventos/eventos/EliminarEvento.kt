package pt.ipg.organizadoreventos.eventos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pt.ipg.organizadoreventos.R

class EliminarEvento : Fragment() {

    companion object {
        fun newInstance() = EliminarEvento()
    }

    private lateinit var viewModel: EliminarEventoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_eliminar_evento, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EliminarEventoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}