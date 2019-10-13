package Objects

class TreeGraph (var head: Node = Node(null)){

    fun lca(a: Node, b:Node) : Node{

        val parentsA = mutableListOf<Node>()
        var nodeA = a
        while (nodeA.hasParent()){
            parentsA.add(nodeA)
            nodeA = nodeA.parent!!
        }
        var nodeB = b
        while (true){
            if (parentsA.contains(nodeB)) return nodeB
            else nodeB = nodeB.parent!!
        }
    }

}
