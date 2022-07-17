package pt.ipg.organizadoreventos.convidados

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import pt.ipg.organizadoreventos.R

class EliminarConvidado : Fragment() {

    companion object {
        fun newInstance() = EliminarConvidado()
    }

    private lateinit var viewModel: EliminarConvidadoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_eliminar_convidado, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EliminarConvidadoViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun processaOpcaoMenu(item: MenuItem) : Boolean =
        when(item.itemId) {
            R.id.action_eliminar -> {
                //eliminaLivro()
                true
            }
            R.id.action_cancelar -> {
                //voltaListaLivros()
                true
            }
            else -> false
        }

}