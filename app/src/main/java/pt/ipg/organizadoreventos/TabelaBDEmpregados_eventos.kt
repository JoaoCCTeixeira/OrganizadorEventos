package pt.ipg.organizadoreventos

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteQueryBuilder
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


    override fun query(
        columns: Array<String>,
        selection: String?,
        selectionArgs: Array<String>?,
        groupBy: String?,
        having: String?,
        orderBy: String?
    ): Cursor {
        val queryBuilder = SQLiteQueryBuilder()
        queryBuilder.tables = "${TabelaBDEmpregados.NOMETABELA}," +
                " ${TabelaBDEventos.NOMETABELA}," +
                " WHERE" +
                " ${TabelaBDEmpregados.ID_EMPREGADOS} = $ID_EMPREGADOS" +
                " AND" +
                " ${TabelaBDEventos.ID_EVENTOS} = $ID_EVENTOS"


        return queryBuilder.query(db, columns, selection, selectionArgs, groupBy, having, orderBy)
    }

}