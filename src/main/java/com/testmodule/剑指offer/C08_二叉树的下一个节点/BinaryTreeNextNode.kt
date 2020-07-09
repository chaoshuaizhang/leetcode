package com.testmodule.剑指offer.C08_二叉树的下一个节点

/**
 * @author  changePosition
 * @date  2020/4/7/007 22:28
 * @desc 给定一个节点，找出中序序列中该节点的下一个节点
 */

fun main() {
    var node_12 = TreeNode(12.0)
    var node_11 = TreeNode(11.0)
    var node_10 = TreeNode(10.0)
    var node_15 = TreeNode(15.0)
    var node_14 = TreeNode(14.0)
    var node_16 = TreeNode(16.0)
    node_12.left = node_11
    node_12.right = node_15
    node_11.left = node_10
    node_15.left = node_14
    node_15.right = node_16
    node_11.parent = node_12
    node_10.parent = node_11
    node_15.parent = node_12
    node_14.parent = node_15
    node_16.parent = node_15
    var binaryTreeNextNode = BinaryTreeNextNode()
    binaryTreeNextNode.zhongxubianli(node_12)
    println("-----")
    binaryTreeNextNode.findNextNode(node_14)

}

class BinaryTreeNextNode {
    /*
    * 下边划分了三种情况，其实也就是两种情况
    * 1：如果有右子树，则查找右孩子的最左孩子
    * 2：如果没有右子树，则一直向上查找父节点parent，直到parent.parent.left == parent
    * */
    fun findNextNode(node: TreeNode?) {
        if (node?.right != null) {
            // 如果有右孩子，查找右孩子最深的左孩子
            var nodeRight = node?.right
            while (nodeRight?.left != null) {
                nodeRight = nodeRight?.left
            }
            println(nodeRight?.value)
        } else if (node?.parent?.left == node) {
            // 如果没有右孩子，则看节点是否是左孩子，如果是，则查找父节点
            println(node?.parent?.value)
        } else {
            // 没有右孩子，并且节点不是左孩子，则一直向上查找，知道查找到父级是父父级的左孩子为止
            var nodeParent = node?.parent
            while (nodeParent != null) {
                if (nodeParent == nodeParent.parent?.left) {
                    println(nodeParent.value)
                    break
                }else{
                    nodeParent = nodeParent.parent
                }
            }
        }
    }

    fun zhongxubianli(node: TreeNode?) {
        if (node != null) {
            zhongxubianli(node.left)
            println(node.value)
            zhongxubianli(node.right)
        }
    }
}

class TreeNode(val value: Double) {
    var parent: TreeNode? = null
    var left: TreeNode? = null
    var right: TreeNode? = null
}