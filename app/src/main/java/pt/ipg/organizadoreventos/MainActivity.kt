package pt.ipg.organizadoreventos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import pt.ipg.organizadoreventos.convidados.EditarConvidado
import pt.ipg.organizadoreventos.convidados.EliminarConvidado
import pt.ipg.organizadoreventos.convidados.ListarConvidados
import pt.ipg.organizadoreventos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    var idMenuAtual = R.menu.menu_main
        get() = field
        set(value) {
            if (value != field) {
                field = value
                invalidateOptionsMenu()
            }
        }

    var menu: Menu? = null

    var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(idMenuAtual, menu)
        this.menu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        val opcaoProcessada: Boolean

        if (fragment is MenuPrincipal) {
            opcaoProcessada = (fragment as MenuPrincipal).processaOpcaoMenu(item)
        }else if (fragment is ListarConvidados) {
            opcaoProcessada = (fragment as ListarConvidados).processaOpcaoMenu(item)
        } else if (fragment is EditarConvidado) {
            opcaoProcessada = (fragment as EditarConvidado).processaOpcaoMenu(item)
        } else if (fragment is EliminarConvidado) {
            opcaoProcessada = (fragment as EliminarConvidado).processaOpcaoMenu(item)
        } else {
            opcaoProcessada = false
        }

        if (opcaoProcessada) return true

        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(androidx.navigation.fragment.R.id.nav_host_fragment_container)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun mostraOpcoesAlterarEliminar(mostra: Boolean) {
        menu!!.findItem(R.id.action_alterar).setVisible(mostra)
        menu!!.findItem(R.id.action_eliminar).setVisible(mostra)
    }

    fun atualizaTitulo(id_string_titulo: Int) {
        binding.toolbar.setTitle(id_string_titulo)
    }

}