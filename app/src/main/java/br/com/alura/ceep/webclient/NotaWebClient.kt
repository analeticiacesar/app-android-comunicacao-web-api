package br.com.alura.ceep.webclient

import android.util.Log
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.model.NotaRequisicao
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

    suspend fun salva(nota: Nota) : Boolean {
        try {
            val resposta = notaService.salva(nota.id, NotaRequisicao(
                titulo = nota.titulo,
                descricao = nota.descricao,
                imagem = nota.imagem
            ))
            return resposta.isSuccessful
        } catch (e: Exception) {
            Log.e("NotaWebClient", "salva: falha ao tentar salvar", e)
        }
        return false
    }

    suspend fun remove(id: String): Boolean {
        try {
            notaService.remove(id)
            return true
        } catch (e: Exception) {
            Log.e("NotaWebClient", "remove: falha ao tentar remover nota", e)
        }
        return false
    }

}