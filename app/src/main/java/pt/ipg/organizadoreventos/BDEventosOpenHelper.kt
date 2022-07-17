package pt.ipg.organizadoreventos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import pt.ipg.organizadoreventos.tabelasBD.*

class BDEventosOpenHelper (context: Context?) : SQLiteOpenHelper(context, NOME, null, VERSAO) {

    override fun onCreate(db: SQLiteDatabase?) {
        requireNotNull(db)

        TabelaBDConvidados(db).cria()
        TabelaBDEmpregados(db).cria()
        TabelaBDEntretenimento(db).cria()
        TabelaBDEventos(db).cria()
        TabelaBDConvidados_eventos(db).cria()
        TabelaBDEmpregados_eventos(db).cria()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    companion object {
        const val NOME = "eventos.db"
        private const val VERSAO = 1
    }

}