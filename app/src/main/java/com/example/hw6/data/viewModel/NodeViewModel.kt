package com.example.hw6.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.hw6.data.NodeDatabase
import com.example.hw6.data.repository.NodeRepository
import com.example.hw6.data.Node
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NodeViewModel(application: Application): AndroidViewModel(application) {

    val readAlldata: LiveData<MutableList<Node>>
    private val repository: NodeRepository

    init {
        val nodeDao = NodeDatabase.getDatabase(application).nodeDao()
        repository = NodeRepository(nodeDao)
        readAlldata = repository.readAllData
    }

    fun addNode(node: Node){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNode(node)
        }
    }
    fun updateNode(value: Int, nodes: MutableList<Node>){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNode(value, nodes)
        }
    }
}