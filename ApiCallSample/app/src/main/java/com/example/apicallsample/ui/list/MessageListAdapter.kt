package com.example.apicallsample.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import br.com.microton.mtwms.ui.common.DataBoundListAdapter
import com.example.apicallsample.AppExecutors
import com.example.apicallsample.R
import com.example.apicallsample.databinding.ListItemMessageBinding
import com.example.apicallsample.model.Message

class MessageListAdapter(
    private val dataBindingComponent: DataBindingComponent,
    private val appExecutors: AppExecutors,
    private val itemClickCallback: ((Message) -> Unit)
) : DataBoundListAdapter<Message, ListItemMessageBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<Message>() {
        override fun areItemsTheSame(oldItem: Message, newItem: Message) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Message, newItem: Message) =
            oldItem.title == newItem.title
                    && oldItem.content == newItem.content
    }
) {
    override fun createBinding(parent: ViewGroup): ListItemMessageBinding {
        val binding = DataBindingUtil.inflate<ListItemMessageBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item_message,
            parent,
            false,
            dataBindingComponent
        )

        binding.root.setOnClickListener {
            binding.message?.let {
                itemClickCallback.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: ListItemMessageBinding, item: Message, position: Int) {
        binding.message = item
    }

}