package pt.ipg.organizadoreventos.tabelasBD

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteQueryBuilder
import android.provider.BaseColumns

class TabelaBDConvidados_eventos (db: SQLiteDatabase) : TabelaBD(db, NOMETABELA) {

    override fun cria(){
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$ID_CONVIDADOS INTEGER NOT NULL, " +
                "$ID_EVENTOS INTEGER NOT NULL, " +
                "FOREIGN KEY ($ID_CONVIDADOS) REFERENCES " +
                "${TabelaBDConvidados.NOMETABELA}(" +
                "${BaseColumns._ID}) ON DELETE RESTRICT," +
                "FOREIGN KEY ($ID_EVENTOS) REFERENCES " +
                "${TabelaBDEventos.NOMETABELA}(" +
                "${BaseColumns._ID}) ON DELETE RESTRICT)")

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
        queryBuilder.tables = "${TabelaBDConvidados.NOMETABELA}," +
                " ${TabelaBDEventos.NOMETABELA}," +
                " WHERE" +
                " ${TabelaBDConvidados.ID_CONVIDADOS} = $ID_CONVIDADOS" +
                " AND" +
                " ${TabelaBDEventos.ID_EVENTOS} = $ID_EVENTOS"


        return queryBuilder.query(db, columns, selection, selectionArgs, groupBy, having, orderBy)
    }

    companion object {
        const val NOMETABELA = "convidados_eventos"
        const val ID_CONVIDADOS = "id_convidados"
        const val ID_EVENTOS = "id_eventos"
    }
}