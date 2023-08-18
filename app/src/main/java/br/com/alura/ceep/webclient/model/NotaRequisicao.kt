package br.com.alura.ceep.webclient.model

import java.io.FileDescriptor

data class NotaRequisicao (
    val titulo: String,
    val descricao: String,
    val imagem: String? = null
)