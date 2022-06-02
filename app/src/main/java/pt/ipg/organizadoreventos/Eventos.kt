package pt.ipg.organizadoreventos

import android.content.ContentValues

data class Eventos (var data: String, var preco: Long, var localizacao: String, var nome: String, var id_entretenimento: Long){

    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        //valores.put(TabelaBDEventos., titulo)
        //valores.put(TabelaBDEventos.CAMPO_AUTOR, autor)
        //valores.put(TabelaBDEventos.CAMPO_CATEGORIA_ID, idCategoria)

        return valores
    }
}