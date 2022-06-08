package pt.ipg.organizadoreventos

import android.content.ContentValues

class Convidados (var nome: String, var numero: String, var cc: String){

    fun toContentValues(): ContentValues{
        val valores = toContentValues()

        valores.put(TabelaBDConvidados.NOME, nome)
        valores.put(TabelaBDConvidados.NUMERO, numero)
        valores.put(TabelaBDConvidados.CC, cc)

        return valores
    }
}