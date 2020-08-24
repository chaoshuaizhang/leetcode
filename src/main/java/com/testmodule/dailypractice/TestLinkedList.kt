package com.testmodule.dailypractice

fun main(args: Array<String>) {
    var header = TestLinkedList.generateLinkedList()
    println("有效节点个数：${TestLinkedList.getLinkedItemCount(header!!)}")
    TestLinkedList.getItemBackCount_K(header, 15)
    TestLinkedList.turnLinkedList(header!!)
}

class Node(var tag: String?, var next: Node?) {}

class TestLinkedList {

    companion object {
        /*
        * 求链表中有效节点的个数
        * */
        fun getLinkedItemCount(header: Node): Int {
            // 无法修改入参，所以只能设置一个局部变量
            var tmp = header
            var count = 0
            while (tmp.next != null) {
                tmp = tmp.next!!
                count++
            }
            return count
        }

        /*
        * 获得倒数第K个元素，k最小是1
        * */
        fun getItemBackCount_K(header: Node, k: Int) {
            // 1. 从头到尾 遍历 k个元素，则剩余的是 n-k
            // 2. 然后再同时开启两个遍历，一个从头开始，一个从上述的n-k
            //    开始，直到n-k这个遍历结束
            var tmp : Node? = header.next
            for (i in 1..k - 1) {
                println(i)
                if (tmp == null) {
                    throw IllegalArgumentException("无效的k = $k $i")
                }
                tmp = tmp.next
            }
            var newTmp = header
            while (tmp?.next != null) {
                tmp = tmp.next!!
                newTmp = newTmp.next!!
            }
            println(newTmp.tag)
        }

        /*
        * 链表反转
        * */
        fun turnLinkedList(header: Node): Node {
            if (header == null || header.next == null)
                throw IllegalArgumentException("链表为空")
            // 把第二个指向第一个的同时保存第三个，第三个指向第二个的同时保存第四个
            // 也就是同一时间要有三个变量
            var node1 = header.next
            var node2 = node1?.next
            // 记得把第一个节点的指针指向null
            node1?.next = null
            while (node2 != null) {
                var node3 = node2.next
                node2.next = node1
                node1 = node2
                node2 = node3
            }
            header.next = node1
            return header
        }

        /*
        * 从尾到头打印链表
        * */
        fun printItemFromTail2Head() {
            // 方式1 反向遍历
            // 方式2 使用stack栈
        }

        /*
        * 归并两个有序链表
        * */
        fun mergeLinkedList() {

        }

        fun generateLinkedList(): Node? {
            var header = Node(null, null)
            var tmp: Node? = header
            for (i in 0..1) {
                tmp?.next = Node("TAG-$i", null)
                tmp = tmp?.next
            }
            return header
        }

    }
}