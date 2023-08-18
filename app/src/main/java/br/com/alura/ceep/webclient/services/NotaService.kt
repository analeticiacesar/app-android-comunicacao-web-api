package br.com.alura.ceep.webclient.services

import br.com.alura.ceep.webclient.model.NotaResposta
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface NotaService {

    @GET("notas")
    fun buscaTodasSemCoroutine(): Call<List<NotaResposta>>

    @GET("notas")
    suspend fun buscaTodas(): Response<List<NotaResposta>>
}