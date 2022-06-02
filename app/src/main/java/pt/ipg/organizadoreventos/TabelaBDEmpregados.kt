package pt.ipg.organizadoreventos

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDEmpregados (db: SQLiteDatabase) : TabelaBD(db, NOMETABELA){

    override fun cria(){
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$NOME TEXT NOT NULL, " +
                "$NUMERO INTEGER NOT NULL, " +
                "$GMAIL TEXT NOT NULL, " +
                "$CC INTEGER NOT NULL)")

    }

    companion object {
        const val NOME = "nome"
        const val NUMERO = "numero"
        const val GMAIL = "gmail"
        const val CC = "cc"
        const val NOMETABELA = "Empregados"
    }

}