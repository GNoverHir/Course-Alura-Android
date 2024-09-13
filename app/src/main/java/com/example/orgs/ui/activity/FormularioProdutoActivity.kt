package com.example.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDAO
import com.example.orgs.model.Produtos
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dao = ProdutosDAO()
        val button = findViewById<Button>(R.id.activitiy_formulario_produto_saveButton)
        button.setOnClickListener {
            val produtoNovo = criarProdutos()

            dao.add(produtoNovo)
            finish()
        }
    }

    private fun criarProdutos(): Produtos {
        val nameEditText = findViewById<EditText>(R.id.activitiy_formulario_produto_nome)
        val name = nameEditText.text.toString()

        val descEditText = findViewById<EditText>(R.id.activitiy_formulario_produto_desc)
        val desc = descEditText.text.toString()

        val valueEditText = findViewById<EditText>(R.id.activitiy_formulario_produto_valor)
        val stringValue = valueEditText.text.toString()
        // Caso passe um valor em branco, bigDecimal vai quebrar. Então aqui fazemos uma pequena verificação.
        //Caso tenha valor em branco, definir como 0. Caso contrario, converta a string em bigDecimal
        val value = if (stringValue.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(stringValue)
        }

        return Produtos(
            nome = name,
            descricao = desc,
            valor = value
        )
    }
}