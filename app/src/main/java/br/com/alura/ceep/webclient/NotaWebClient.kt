package br.com.alura.ceep.webclient

import android.util.Log
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.services.NotaService

class NotaWebClient {

    private val notaService: NotaService = RetrofitInicializador().notaService

    suspend fun buscaTodas(): List<Nota>? {
        return try {
            val notasResposta = notaService.buscaTodas()
            notasResposta.body()?.map { notaResposta ->
                notaResposta.nota
            }
        } catch (e: Exception) {
            Log.e("NotaWebClient", "buscaTodas: ", e)
            null
        }
    }

}