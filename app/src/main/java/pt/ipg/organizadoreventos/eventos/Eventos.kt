package pt.ipg.organizadoreventos.eventos

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import pt.ipg.organizadoreventos.tabelasBD.TabelaBDEventos

data class Eventos (var data: String, var preco: Long, var localizacao: String, var nome: String, var id_entretenimento: Long, var id: Long = -1){

    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDEventos.DATA, data)
        valores.put(TabelaBDEventos.PRECO, preco)
        valores.put(TabelaBDEventos.LOCALIZACAO, localizacao)
        valores.put(TabelaBDEventos.NOME, nome)
        valores.put(TabelaBDEventos.ID_ENTRETENIMENTO, id_entretenimento)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Eventos {
            val posId = cursor.getColumnIndex(BaseColumns._ID)

            val posData = cursor.getColumnIndex(TabelaBDEventos.DATA)
            val posPreco = cursor.getColumnIndex(TabelaBDEventos.PRECO)
            val posLocalizacao = cursor.getColumnIndex(TabelaBDEventos.LOCALIZACAO)
            val posNome = cursor.getColumnIndex(TabelaBDEventos.NOME)
            val posIdEntretenimento = cursor.getColumnIndex(TabelaBDEventos.ID_ENTRETENIMENTO)

            val id = cursor.getLong(posId)

            val data = cursor.getString(posData)
            val preco = cursor.getLong(posPreco)
            val localizacao = cursor.getString(posLocalizacao)
            val nome = cursor.getString(posNome)
            val idEntretenimento = cursor.getLong(posIdEntretenimento)

            return Eventos( data, preco, localizacao,nome, idEntretenimento, id)
        }
    }
}