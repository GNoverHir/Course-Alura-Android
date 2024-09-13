package com.example.orgs.dao

import com.example.orgs.model.Produtos

class ProdutosDAO {

    private val produtosLista = mutableListOf<Produtos>();

    fun add(produto: Produtos){
        produtosLista.add(produto)
    }

    fun buscarTodos() : List<Produtos> {
        return produtosLista.toList()
    }
}