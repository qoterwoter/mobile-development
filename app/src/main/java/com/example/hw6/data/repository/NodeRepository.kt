package com.example.hw6.data.repository

import com.example.hw6.data.NodeDao
import com.example.hw6.data.Node

class NodeRepository(private val nodeDao: NodeDao) {

    val readAllData = nodeDao.readAllData()

    suspend fun addNode(node: Node){
        nodeDao.addNode(node)
    }

    suspend fun updateNode(value: Int, nodes: MutableList<Node>){
        nodeDao.updateNode(value, nodes)
    }
}