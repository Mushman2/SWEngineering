package Objects

class DAGraph (var head: Node = Node()){

    fun lca(a: Node, b:Node) : Node{

        var currentA = listOf(a)
        val allA = mutableListOf(a)
        var currentB = listOf(b)
        val allB = mutableListOf(b)

        while(true){
            for (node in currentA){
                if (allB.contains(node)) return node
            }
            for (node in currentB){
                if (allA.contains(node)) return node
            }

            currentA = currentA.map { it.parents }.flatten()
            allA.addAll(currentA)
            currentB = currentB.map { it.parents }.flatten()
            allB.addAll(currentB)
        }
    }
}
