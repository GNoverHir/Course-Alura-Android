package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDAO
import com.example.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val dao = ProdutosDAO()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscarTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
        configuraRecyclerView()
        configuraFab()


    }

    override fun onResume() {
        super.onResume()
        adapter.atualizar(dao.buscarTodos())
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_lista_produtos_fab)
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_produtos_reciclerView)
        recyclerView.adapter = adapter
    }
}