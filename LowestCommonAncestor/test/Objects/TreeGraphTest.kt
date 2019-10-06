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
        fun testLCAforBinaryTree(){

            val graph = TreeGraph()
            val lca = GenerateTreeGivingRandomLeaf(graph.head)
            lca.createLeft()
            val a = GenerateTreeGivingRandomLeaf(lca.left!!)
            lca.createRight()
            val b = GenerateTreeGivingRandomLeaf(lca.right!!)

            assertEquals(graph.lca(a,b), lca)

        }

        private fun GenerateTreeGivingRandomLeaf(root: Node) : Node {
            root.createLeft()
            root.createRight()

            LeavesToDepth(root.left!!, 10)
            LeavesToDepth(root.right!!, 10)

            var leaf = root

            while (leaf.left != null || leaf.right != null) {
                if (leaf.left == null) {
                    leaf = leaf.right!!
                }
                else if (leaf.right == null){
                    leaf = leaf.left!!
                }
                else{
                    if(random.nextBoolean()) leaf = leaf.left!!
                    else leaf = leaf.right!!


                }
            }

            return leaf
        }

        private fun LeavesToDepth(root: Node, depth:Int) {
            if (depth > 1){
                if (random.nextBoolean()){
                    root.createLeft()
                    LeavesToDepth(root.left!!,depth-1)
                }

                if (random.nextBoolean()){
                    root.createRight()
                    LeavesToDepth(root.right!!,depth-1)
                }
            }
        }
    }
}