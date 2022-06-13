package pt.ipg.organizadoreventos

import android.content.ContentValues

class Entretenimento (var tema: String, var id: Long = -1){

    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDEntretenimento.TEMA, tema)

        return valores
    }
}