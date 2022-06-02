package pt.ipg.organizadoreventos

import android.content.ContentValues

data class empregados_eventos (var id_empregados: Long, var id_eventos: Long){

    fun toContentValues() : ContentValues{
        val valores = toContentValues()

        //valores.put(TabelaBDEmpregados_eventos.nome)
        return valores
    }


}