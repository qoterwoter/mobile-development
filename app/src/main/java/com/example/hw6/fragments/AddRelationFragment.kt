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
import kotlinx.android.synthetic.main.add_dialog.view.*

class AddRelationFragment(private var leftNode: Node, private var rightNode: Node, private var statusBool: Boolean)
    :DialogFragment() {

    private lateinit var mNodeViewModel: NodeViewModel

    private fun addRelation(isParent: Boolean) {
        when(isParent) {
            false -> mNodeViewModel.updateNode(
                rightNode.value, (rightNode.nodes + mutableListOf(Node(leftNode.value, leftNode.nodes))) as MutableList<Node>
            )
            true -> mNodeViewModel.updateNode(
                leftNode.value, (leftNode.nodes + mutableListOf(Node(rightNode.value, rightNode.nodes))) as MutableList<Node>
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mNodeViewModel = ViewModelProvider(this)[NodeViewModel::class.java]
        val rootView: View = inflater.inflate(R.layout.add_dialog, container, false)

        rootView.approve_add_but.setOnClickListener {
            addRelation(statusBool)
            dismiss()
        }
        rootView.cancel_add_but.setOnClickListener {
            dismiss()
        }

        return rootView
    }
}