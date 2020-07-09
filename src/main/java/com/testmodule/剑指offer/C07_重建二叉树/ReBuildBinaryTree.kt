package com.testmodule.剑指offer.C07_重建二叉树

import sun.reflect.generics.tree.Tree

/**
 * @author  changePosition
 * @date  2020/3/14/014 16:06
 */

fun main() {
    var binaryTree = BinaryTree()
    binaryTree.reBuild(0, binaryTree.xianxu.size - 1)
    // 层序遍历
    binaryTree.cengxubianli(binaryTree.root)
}

class BinaryTree {

    var index = 0
    //    var xianxu = arrayOf(5.0, 6.0, 7.0, 8.0, 9.0)
//    var zhongxu = arrayOf(5.0, 6.0, 7.0, 9.0, 8.0)
    var xianxu = arrayOf(9.0, 7.0, 6.0, 6.5)
    var zhongxu = arrayOf(6.5, 6.0, 7.0, 9.0)
    var rootNode: TreeNode? = null
    // 保存根节点
    lateinit var root: TreeNode

    /*
    * 根据先序遍历序列和中序遍历序列，还原出二叉树的原貌
    * */
    fun reBuild(start: Int, end: Int) {
        for (i in start..end) {
            if (index == xianxu.size) {
                break
            }
            if (xianxu[index] == zhongxu[i]) {
                index++
                var node = TreeNode(null, zhongxu[i], null)
                if (rootNode == null) {
                    rootNode = node
                    root = rootNode!!
                } else {
                    if (node.value < rootNode!!.value) {
                        rootNode?.left = node
                    } else {
                        rootNode?.right = node
                    }
                    rootNode = node
                }
                reBuild(start, i - 1)
                // 左子树遍历完成，重新设置父节点，继续右子树
                // 【非常重要】
                rootNode = node
                reBuild(i + 1, end)
            } else if (xianxu[index] < zhongxu[i]) {
                println("二叉树不合法")
                return
            }
        }
    }

    /*
    * 层序遍历
    * */
    fun cengxubianli(node: TreeNode?) {
        if (node != null) {
            println(node.value)
            cengxubianli(node.left)
            cengxubianli(node.right)
        }
    }

    data class TreeNode(var left: TreeNode?, var value: Double, var right: TreeNode?)

}