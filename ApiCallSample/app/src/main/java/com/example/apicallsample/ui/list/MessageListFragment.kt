package com.example.apicallsample.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.microton.mtwms.binding.FragmentDataBindingComponent
import com.example.apicallsample.AppExecutors
import com.example.apicallsample.R
import com.example.apicallsample.util.autoCleared
import kotlinx.android.synthetic.main.fragment_message_list.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MessageListFragment : Fragment() {

    private val appExecutors: AppExecutors by inject()
    private val dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)
    private var adapter by autoCleared<MessageListAdapter>()
    private val viewModel: MessageListViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        initMessageList()
    }

    private fun setupRecycler() {
        val adapter = MessageListAdapter(dataBindingComponent,appExecutors){message ->  }
        this.adapter = adapter

        recyclerView.adapter = adapter
    }

    private fun initMessageList() {
        viewModel.messages.observe(
            viewLifecycleOwner,
            Observer { messageList ->
                adapter.submitList(messageList.map { it.copy() })
            }
        )
    }
}