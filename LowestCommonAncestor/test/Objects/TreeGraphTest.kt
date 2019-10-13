package Objects

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.*

class TreeGraphTest{

    @Nested
    inner class LCATests{

        val random = Random()

        @Test
        fun testLCAForBinaryTree(){

            val graph = TreeGraph()
            val lca = generateTreeGivingRandomLeaf(graph.head)
            lca.createLeft()
            val a = generateTreeGivingRandomLeaf(lca.left!!)
            lca.createRight()
            val b = generateTreeGivingRandomLeaf(lca.right!!)

            assertEquals(graph.lca(a,b), lca ,"LCA of separated Nodes")
            assertEquals(graph.lca(lca, a), lca, "LCA where a is LCA")
            assertEquals(graph.lca(a, lca), lca, "LCA where b is LCA")
            assertEquals(graph.lca(a,a), a,"LCA of a same node is itself")
        }


        private fun generateTreeGivingRandomLeaf(root: Node) : Node {
            root.createLeft()
            root.createRight()

            leavesToDepth(root.left!!, 10)
            leavesToDepth(root.right!!, 10)

            var leaf = root

            while (leaf.left != null || leaf.right != null) {
                if (leaf.left == null) {
                    leaf = leaf.right!!
                }
                else if (leaf.right == null){
                    leaf = leaf.left!!
                }
                else{
                    leaf = if(random.nextBoolean()) leaf.left!!
                    else leaf.right!!


                }
            }

            return leaf
        }

        private fun leavesToDepth(root: Node, depth:Int) {
            if (depth > 1){
                if (random.nextBoolean()){
                    root.createLeft()
                    leavesToDepth(root.left!!,depth-1)
                }

                if (random.nextBoolean()){
                    root.createRight()
                    leavesToDepth(root.right!!,depth-1)
                }
            }
        }
    }
}