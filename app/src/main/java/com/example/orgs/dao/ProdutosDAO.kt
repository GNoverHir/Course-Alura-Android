package com.example.orgs.dao

import com.example.orgs.model.Produtos

class ProdutosDAO {

    fun add(produto: Produtos){
        produtosLista.add(produto)
    }

    fun buscarTodos() : List<Produtos> {
        return produtosLista.toList()
    }

    companion object {
        private val produtosLista = mutableListOf<Produtos>();
    }
}