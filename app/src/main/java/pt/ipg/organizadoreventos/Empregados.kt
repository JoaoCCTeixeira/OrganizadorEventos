package pt.ipg.organizadoreventos

import android.content.ContentValues

class Empregados (var nome: String, var numero: Long, var gmail: String, var cc: Long){

    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDEmpregados.NOME, nome)
        valores.put(TabelaBDEmpregados.NUMERO, numero)
        valores.put(TabelaBDEmpregados.GMAIL, gmail)
        valores.put(TabelaBDEmpregados.CC, cc)

        return valores
    }
}