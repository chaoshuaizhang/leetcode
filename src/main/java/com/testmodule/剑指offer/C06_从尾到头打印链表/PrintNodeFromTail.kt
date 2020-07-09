package com.testmodule.剑指offer.C06_从尾到头打印链表

import java.util.*

/**
 * @author  changePosition
 * @date  2020/3/13/013 15:05
 */
fun main() {
    var node: Node? = Node(1)
    val header = node
    node?.next = Node(2)
    node = node?.next
    node?.next = Node(3)
    node = node?.next
    node?.next = Node(4)
    node = node?.next
    node?.next = Node(5)
    node = node?.next
    node?.next = Node(6)
    node = node?.next
    node?.next = Node(7)
    node = node?.next
    node?.next = Node(8)
    node = node?.next
    node?.next = Node(9)
    node?.next?.next = null
    var printNodeFromTail = PrintNodeFromTail()
     printNodeFromTail.printNode(null)
     printNodeFromTail.printWithRecursive(null)
     printNodeFromTail.printWithStack(null)
    printNodeFromTail.printWithMyStack(null)
}

data class Node(var value: Int) {
    var next: Node? = null
}

/*
* 给你一个头节点，从尾到头打印单链表
* */
class PrintNodeFromTail {

    /*
    * 先反转，再打印
    * */
    fun printNode(node: Node?) {

        // 三个一组依次后移
        // header表示第一个元素（初始是null）
        var header: Node? = null
        // 保存第一个实际元素
        var head = node

        var headNext: Node?
        while (head != null) {
            if (head?.next == null) {
                head.next = header
                break
            }
            var tmp = head.next?.next
            if (tmp == null) {
                headNext = head.next
                headNext?.next = head
                head.next = header
                head = headNext
                break
            } else {
                headNext = head.next
                headNext?.next = head
                head.next = header
                header = headNext
                head = tmp
            }
        }

        while (head != null) {
            println(head.value)
            head = head.next
        }


    }

    fun printWithStack(node: Node?) {
        var stack = Stack<Int>()
        var tmpNode = node
        while (tmpNode != null) {
            stack.push(tmpNode.value)
            tmpNode = tmpNode.next
        }
        for (i in 0 until stack.size) {
            println(stack.pop())
        }
    }

    fun printWithMyStack(node: Node?) {
        var myStack = MyStack()
        var header = node
        while (header != null) {
            myStack.push(header.value)
            header = header.next
        }
        for (i in 0..myStack.count) {
            println(myStack.pop())
        }
    }

    /*
    * 使用递归时，注意链表最后一个元素的输出
    * */
    fun printWithRecursive(node: Node?) {
        if (node != null) {
            if (node.next != null) {
                printWithRecursive(node.next)
            }
            println(node.value)
        }
    }

    abstract class AbsStack<T> {

        lateinit var array: Array<Any?>
        var count = -1

        constructor() : this(5)
        constructor(size: Int) {
            array = arrayOfNulls(size)
        }

        fun addElement(t: T): T {
            if (count == array.size - 1) {
                // 扩容
                println("----- 开始扩容 -----")
                array = array.copyOf(count + 1 + growSize())
            }
            // 插入
            array[++count] = t
            return t
        }

        fun removeElement(index: Int): T {
            if (index < 0) {
                throw IndexOutOfBoundsException("输入下标异常 index = $index con't < 0")
            }
            if (index > count) {
                throw IndexOutOfBoundsException("输入下标越界 index = $index con't > count $count")
            }
            return (array[count--] as T?)!!
        }

        abstract fun growSize(): Int

    }

    class MyStack : AbsStack<Int>() {
        override fun growSize(): Int {
            return 1
        }

        fun push(v: Int): Int {
            return addElement(v)
        }

        fun pop(): Int {
            return removeElement(count)
        }

    }

}