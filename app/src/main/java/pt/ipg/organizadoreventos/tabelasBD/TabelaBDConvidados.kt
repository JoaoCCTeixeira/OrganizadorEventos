package pt.ipg.organizadoreventos.tabelasBD

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDConvidados (db: SQLiteDatabase) : TabelaBD(db, NOMETABELA){

    override fun cria(){
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$NOME TEXT NOT NULL, " +
                "$NUMERO INTEGER NOT NULL, " +
                "$CC INTEGER NOT NULL) ")


    }

    companion object {
        const val NOME = "nome"
        const val NUMERO = "numero"
        const val CC = "cc"
        const val NOMETABELA = "convidados"
        const val ID_CONVIDADOS = "id_convidados"
    }



}