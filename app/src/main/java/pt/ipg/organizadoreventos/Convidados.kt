package pt.ipg.organizadoreventos

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

class Convidados (var nome: String, var numero: String, var cc: String, var id: Long = -1){

    fun toContentValues(): ContentValues{
        val valores = toContentValues()

        valores.put(TabelaBDConvidados.NOME, nome)
        valores.put(TabelaBDConvidados.NUMERO, numero)
        valores.put(TabelaBDConvidados.CC, cc)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Convidados {
            val posId = cursor.getColumnIndex(BaseColumns._ID)

            val posNome = cursor.getColumnIndex(TabelaBDConvidados.NOME)
            val posNumero = cursor.getColumnIndex(TabelaBDConvidados.NUMERO)
            val posCC = cursor.getColumnIndex(TabelaBDConvidados.CC)

            val id = cursor.getLong(posId)
            val nome = cursor.getString(posNome)
            val numero = cursor.getString(posNumero)
            val cc = cursor.getString(posCC)

            return Convidados(nome, numero, cc, id)
        }
    }
}