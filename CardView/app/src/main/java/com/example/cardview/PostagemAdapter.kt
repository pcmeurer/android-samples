package com.example.cardview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.example.cardview.databinding.ListItemPostagemBinding
import com.example.cardview.model.Postagem
import com.example.cardview.ui.common.DataBoundListAdapter
import com.example.recycler.AppExecutors

class PostagemAdapter(
    val appExecutors: AppExecutors,
    val dataBindingComponent: DataBindingComponent
) : DataBoundListAdapter<Postagem, ListItemPostagemBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<Postagem>() {
        override fun areItemsTheSame(oldItem: Postagem, newItem: Postagem) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Postagem, newItem: Postagem) =
            oldItem.postagem == newItem.postagem
    }

) {
    override fun createBinding(parent: ViewGroup): ListItemPostagemBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_postagem,
            parent,
            false,
            dataBindingComponent
        )
    }

    override fun bind(binding: ListItemPostagemBinding, item: Postagem, position: Int) {
        binding.postagem = item
    }

}