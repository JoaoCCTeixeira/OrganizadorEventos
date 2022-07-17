package pt.ipg.organizadoreventos.empregados

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import pt.ipg.organizadoreventos.tabelasBD.TabelaBDEmpregados

class Empregados (var nome: String, var numero: String, var gmail: String, var cc: String, var id: Long = -1){

    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDEmpregados.NOME, nome)
        valores.put(TabelaBDEmpregados.NUMERO, numero)
        valores.put(TabelaBDEmpregados.GMAIL, gmail)
        valores.put(TabelaBDEmpregados.CC, cc)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Empregados {
            val posId = cursor.getColumnIndex(BaseColumns._ID)

            val posNome = cursor.getColumnIndex(TabelaBDEmpregados.NOME)
            val posNumero = cursor.getColumnIndex(TabelaBDEmpregados.NUMERO)
            val posGMAIL = cursor.getColumnIndex(TabelaBDEmpregados.GMAIL)
            val posCC = cursor.getColumnIndex(TabelaBDEmpregados.CC)

            val id = cursor.getLong(posId)

            val nome = cursor.getString(posNome)
            val numero = cursor.getString(posNumero)
            val gmail = cursor.getString(posGMAIL)
            val cc = cursor.getString(posCC)

            return Empregados(nome, numero,gmail, cc, id)
        }
    }
}