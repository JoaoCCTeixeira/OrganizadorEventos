package pt.ipg.organizadoreventos

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDEntretenimento (db: SQLiteDatabase) : TabelaBD(db, NOMETABELA){

    override fun cria(){
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$TEMA INTEGER NOT NULL)")

    }

    companion object {
        const val TEMA = "tema"
        const val NOMETABELA = "Entretenimento"
    }

}