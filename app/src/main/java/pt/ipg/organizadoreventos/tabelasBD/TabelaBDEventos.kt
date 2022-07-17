package pt.ipg.organizadoreventos.tabelasBD

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteQueryBuilder
import android.provider.BaseColumns

class TabelaBDEventos (db: SQLiteDatabase) : TabelaBD(db, NOMETABELA){

    override fun cria(){
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$DATA TEXT NOT NULL, " +
                "$PRECO REAL NOT NULL, " +
                "$LOCALIZACAO TEXT NOT NULL, " +
                "$NOME TEXT NOT NULL, " +
                "$ID_ENTRETENIMENTO INTEGER NOT NULL, " +
                "FOREIGN KEY ($ID_ENTRETENIMENTO) REFERENCES " +
                "${TabelaBDEntretenimento.NOMETABELA}(" +
                "${BaseColumns._ID}) ON DELETE RESTRICT)")

    }

    companion object {
        const val DATA = "data"
        const val PRECO = "preco"
        const val LOCALIZACAO = "localizacao"
        const val NOME = "nome"
        const val ID_ENTRETENIMENTO = "id_entretenimento"
        const val NOMETABELA = "Eventos"
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
        queryBuilder.tables = "${TabelaBDEntretenimento.NOMETABELA}," +
                " ${TabelaBDConvidados_eventos.NOMETABELA}," +
                " ${TabelaBDEmpregados_eventos.NOMETABELA}," +
                " WHERE" +
                " ${TabelaBDEntretenimento.ID_ENTRETENIMENTO} = $ID_ENTRETENIMENTO" +
                " AND" +
                " ${TabelaBDConvidados_eventos.ID_EVENTOS} = $ID_EVENTOS}"+
                " AND" +
                " ${TabelaBDEmpregados_eventos.ID_EVENTOS} = $ID_EVENTOS}"


        return queryBuilder.query(db, columns, selection, selectionArgs, groupBy, having, orderBy)
    }

}