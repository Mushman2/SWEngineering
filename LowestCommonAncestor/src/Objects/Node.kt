package Objects

class Node (var parent:Node?) {

    var left : Node? = null
    var right : Node? = null

    fun createLeft(){
        if(left == null) {
            left = Node(this)
        }
        else throw Exception("Tried to overwrite left node")
    }

    fun createRight(){
        if(right == null) {
            right = Node(this)
        }
        else throw Exception("Tried to overwrite right node")
    }

    fun hasParent() : Boolean{
        return parent != null
    }
}

