package pt.ipg.organizadoreventos

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import pt.ipg.organizadoreventos.tabelasBD.TabelaBDEmpregados_eventos

data class empregados_eventos (var id_empregados: Long, var id_eventos: Long, var id: Long = -1){

    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDEmpregados_eventos.ID_EMPREGADOS, id_empregados)
        valores.put(TabelaBDEmpregados_eventos.ID_EVENTOS, id_eventos)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): empregados_eventos {
            val posId = cursor.getColumnIndex(BaseColumns._ID)

            val posIdEmpregados = cursor.getColumnIndex(TabelaBDEmpregados_eventos.ID_EMPREGADOS)
            val posIdEventos = cursor.getColumnIndex(TabelaBDEmpregados_eventos.ID_EVENTOS)

            val id = cursor.getLong(posId)

            val idEmpregados = cursor.getLong(posIdEmpregados)
            val idEventos = cursor.getLong(posIdEventos)

            return empregados_eventos(idEmpregados,idEventos, id)
        }
    }
}