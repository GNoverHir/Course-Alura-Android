package com.example.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDAO
import com.example.orgs.model.Produtos
import com.example.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "meu primeiro toast", Toast.LENGTH_SHORT).show()


//
//        val nome = findViewById<TextView>(R.id.nome)
//        nome.text = "Cesta de frutas"
//
//        val descricao = findViewById<TextView>(R.id.descricao)
//        descricao.text = "Laranja, maçã e uva"
//
//        val valor = findViewById<TextView>(R.id.valor)
//        valor.text = "9,99"


        val dao = ProdutosDAO()
        val recyclerView = findViewById<RecyclerView>(R.id.reciclerView)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = dao.buscarTodos())

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }
}