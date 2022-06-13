package pt.ipg.organizadoreventos

import android.content.ContentValues

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
}