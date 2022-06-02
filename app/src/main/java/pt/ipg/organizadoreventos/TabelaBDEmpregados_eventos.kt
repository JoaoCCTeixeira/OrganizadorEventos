package pt.ipg.organizadoreventos

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDEmpregados_eventos (db: SQLiteDatabase) : TabelaBD(db, NOMETABELA) {

    override fun cria(){
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$ID_EMPREGADOS INTEGER NOT NULL, " +
                "$ID_EVENTOS INTEGER NOT NULL, " +
                "FOREIGN KEY ($ID_EMPREGADOS) REFERENCES " +
                "${TabelaBDEmpregados.NOMETABELA}(" +
                "${BaseColumns._ID}) ON DELETE RESTRICT," +
                "FOREIGN KEY ($ID_EVENTOS) REFERENCES " +
                "${TabelaBDEventos.NOMETABELA}(" +
                "${BaseColumns._ID}) ON DELETE RESTRICT)")

    }

    companion object {
        const val NOMETABELA = "empregados_eventos"
        const val ID_EMPREGADOS = "id_empregados"
        const val ID_EVENTOS = "id_eventos"
    }

}