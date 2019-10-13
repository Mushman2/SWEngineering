package Objects

import java.util.*

class Node {

    var parents = mutableListOf<Node>()
    var children = mutableListOf<Node>()

    fun createChild () : Node {
        val newNode = Node()
        children.add(newNode)
        newNode.parents.add(this)
        return newNode
    }

    fun addChild(newChild:Node){
        children.add(newChild)
        newChild.parents.add(this)
    }

}

