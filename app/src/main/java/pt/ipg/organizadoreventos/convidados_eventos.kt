package pt.ipg.organizadoreventos

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import pt.ipg.organizadoreventos.tabelasBD.TabelaBDConvidados_eventos

class convidados_eventos (var id_convidados: Long, var id_eventos: Long, var id: Long = -1){

    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDConvidados_eventos.ID_CONVIDADOS, id_convidados)
        valores.put(TabelaBDConvidados_eventos.ID_EVENTOS, id_eventos)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): convidados_eventos {
            val posId = cursor.getColumnIndex(BaseColumns._ID)

            val posIdConvidados = cursor.getColumnIndex(TabelaBDConvidados_eventos.ID_CONVIDADOS)
            val posIdEventos = cursor.getColumnIndex(TabelaBDConvidados_eventos.ID_EVENTOS)

            val id = cursor.getLong(posId)
            val idConvidados = cursor.getLong(posIdConvidados)
            val idEventos = cursor.getLong(posIdEventos)

            return convidados_eventos(idConvidados,idEventos, id)
        }
    }
}