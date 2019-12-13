package com.example.componentesbasicos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btEnviar.setOnClickListener { _ ->
            //            tvResultado.text = edtNomeProduto.text.toString()
//            tvResultado.text = "Cores selecionadas: \n ${getCoresSelecionadas().joinToString()}"
//            tvResultado.text =
//                if (getPossuiEstoque()) "Produto possui estoque" else "Produto não possui estoque"
//            ilNomeProduto.error = "Nome do produto inválido!"
        }

    }

    private fun getCoresSelecionadas(): List<String> {
        val listaCores = mutableListOf<String>()
        cbBranco.text.toString()
            .takeIf { cbBranco.isChecked }
            ?.let { listaCores.add(it) }

        cbVerde.text.toString()
            .takeIf { cbVerde.isChecked }
            ?.let { listaCores.add(it) }

        cbVermelho.text.toString()
            .takeIf { cbVermelho.isChecked }
            ?.let { listaCores.add(it) }

        return listaCores
    }

    private fun getPossuiEstoque() = rgEstoque.checkedRadioButtonId == R.id.rbPossuiEstoque
}
