package pt.ipg.organizadoreventos

import android.content.ContentValues

class Empregados (var nome: String, var numero: String, var gmail: String, var cc: String, var id: Long = -1){

    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDEmpregados.NOME, nome)
        valores.put(TabelaBDEmpregados.NUMERO, numero)
        valores.put(TabelaBDEmpregados.GMAIL, gmail)
        valores.put(TabelaBDEmpregados.CC, cc)

        return valores
    }
}