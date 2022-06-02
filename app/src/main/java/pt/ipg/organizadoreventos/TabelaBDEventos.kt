package pt.ipg.organizadoreventos

import android.database.sqlite.SQLiteDatabase
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
    }

}