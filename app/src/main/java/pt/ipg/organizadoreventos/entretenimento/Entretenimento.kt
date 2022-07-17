package pt.ipg.organizadoreventos.entretenimento

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import pt.ipg.organizadoreventos.tabelasBD.TabelaBDEntretenimento

class Entretenimento (var tema: String, var id: Long = -1){

    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDEntretenimento.TEMA, tema)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Entretenimento {
            val posId = cursor.getColumnIndex(BaseColumns._ID)

            val posTema = cursor.getColumnIndex(TabelaBDEntretenimento.TEMA)

            val id = cursor.getLong(posId)

            val tema = cursor.getString(posTema)

            return Entretenimento(tema, id)
        }
    }
}