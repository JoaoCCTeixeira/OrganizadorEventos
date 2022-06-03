package pt.ipg.organizadoreventos

import android.content.ContentValues

class convidados_eventos (var id_convidados: Long, var id_eventos: Long){

    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDConvidados_eventos.ID_CONVIDADOS, id_convidados)
        valores.put(TabelaBDConvidados_eventos.ID_EVENTOS, id_eventos)

        return valores
    }
}