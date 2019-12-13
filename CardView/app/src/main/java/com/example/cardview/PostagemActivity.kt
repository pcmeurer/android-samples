package com.example.cardview

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingComponent
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.recycler.AppExecutors
import kotlinx.android.synthetic.main.activity_postagem.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostagemActivity : AppCompatActivity() {

    private val viewModel: PostagemViewModel by viewModel()
    private val appExecutors: AppExecutors by inject()
    private val dataBindingComponent = object : DataBindingComponent {}
    private lateinit var adapter: PostagemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postagem)

        initViewComponents()
        initListPostagens()
    }

    private fun initViewComponents() {
        adapter = PostagemAdapter(appExecutors, dataBindingComponent)

        recyclerPostagem.adapter = adapter
    }

    private fun initListPostagens() {
        viewModel.listaPostagens
            .observe(
                this,
                Observer { postagens ->
                    adapter.submitList(postagens)
                }
            )
    }
}
