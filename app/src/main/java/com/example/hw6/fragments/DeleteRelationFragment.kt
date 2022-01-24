package com.example.hw6.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.hw6.R
import com.example.hw6.data.Node
import com.example.hw6.data.viewModel.NodeViewModel
import kotlinx.android.synthetic.main.delete_dialog.view.*

class DeleteRelationFragment(private var leftNode: Node, private var rightNode: Node, private var statusBool: Boolean)
    :DialogFragment() {

    private lateinit var mNodeViewModel: NodeViewModel

    private fun deleteRelation(isParent: Boolean) {
        when(isParent) {
            true -> mNodeViewModel.updateNode(
                leftNode.value, leftNode.nodes.filter { it.value != rightNode.value } as MutableList<Node>
            )
            false -> mNodeViewModel.updateNode(
                rightNode.value, rightNode.nodes.filter { it.value != leftNode.value } as MutableList<Node>
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mNodeViewModel = ViewModelProvider(this)[NodeViewModel::class.java]
        val rootView: View = inflater.inflate(R.layout.delete_dialog, container, false)

        rootView.approve_delete_but.setOnClickListener {
            deleteRelation(statusBool)
            dismiss()
        }
        rootView.cancel_delete_but.setOnClickListener {
            dismiss()
        }

        return rootView
    }
}