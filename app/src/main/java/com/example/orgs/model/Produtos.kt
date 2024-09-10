package com.example.orgs.model

import java.math.BigDecimal

// É O MESMO DATA DO SPRING (We are the champions tocando no fundo*)
data class Produtos (
    val nome: String,
    val descricao: String,
    val valor: BigDecimal
)
