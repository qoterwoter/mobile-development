package com.example.hw6.data.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class NodeViewModelFactory(private var application: Application):ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NodeViewModel::class.java)){
            return NodeViewModel(application) as T
        }
        throw IllegalArgumentException("Class not finding")
    }
}