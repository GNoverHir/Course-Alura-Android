package com.example.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Produtos
import com.example.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
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

        val recyclerView = findViewById<RecyclerView>(R.id.reciclerView)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
                Produtos(nome = "Cesta de frutas",
                        descricao = "Laranja e maçã",
                        valor = BigDecimal("19.99")
                ),
                Produtos(nome = "Carros",
                        descricao = "Hyundai e Peugeot",
                        valor = BigDecimal("60.000")
                ),
                Produtos(nome = "Cachorros",
                        descricao = "Poodle e Golden",
                        valor = BigDecimal("10.000")
                )

            )
        )
    }
}