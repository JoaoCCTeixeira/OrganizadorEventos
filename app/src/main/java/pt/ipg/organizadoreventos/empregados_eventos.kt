package pt.ipg.organizadoreventos

import android.content.ContentValues

data class empregados_eventos (var id_empregados: Long, var id_eventos: Long, var id: Long = -1){

    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDEmpregados_eventos.ID_EMPREGADOS, id_empregados)
        valores.put(TabelaBDEmpregados_eventos.ID_EVENTOS, id_eventos)

        return valores
    }
}