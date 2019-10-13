package Objects

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.*

class DAGraphTest{

    @Nested
    inner class LCATests{

        var lca:Node = Node()
        var a:Node = Node()
        var b:Node = Node()

        @Test
        fun testLCAForBinaryTree(){

            val graph = DAGraph()

            //Randomly generating the graph would be too much work for this test, so I will create the graph manually
            generateGraph(graph)

            assertEquals(graph.lca(a,b), lca ,"LCA of separated Nodes")
            assertEquals(graph.lca(lca, a), lca, "LCA where a is LCA")
            assertEquals(graph.lca(a, lca), lca, "LCA where b is LCA")
            assertEquals(graph.lca(a,a), a,"LCA of a same node is itself")
        }

        //Creates a DAG and sets lca, A and B
        fun generateGraph(graph : DAGraph){
              var node = graph.head.createChild()
              lca = node.createChild()
              node = node.createChild()
              node = node.createChild()
              lca.addChild(node)
              a = lca.createChild()
              a = a.createChild()
              node = node.createChild()
              b = node.createChild()
              b = b.createChild()
              node = node.createChild()
        }

    }
}