package com.testmodule.剑指offer.C09_两个栈实现一个队列

import java.util.*

/**
 * @author  changePosition
 * @date  2020/4/8/008 9:41
 */

fun main() {
    val queue = TwoStack2Queue()
    queue.appendTail("1")
    queue.appendTail("2")
    queue.appendTail("3")
    queue.appendTail("4")
    queue.appendTail("5")
    queue.appendTail("6")
    queue.appendTail("7")
    queue.deleteHead()
    queue.deleteHead()
    queue.deleteHead()
    queue.appendTail("8")
    queue.appendTail("9")
    queue.appendTail("10")
    queue.deleteHead()
    queue.deleteHead()
    queue.deleteHead()
    queue.deleteHead()
    queue.deleteHead()
    queue.deleteHead()
    queue.deleteHead()
    queue.deleteHead()
    queue.deleteHead()
    queue.deleteHead()
    queue.deleteHead()
}

class TwoStack2Queue {

    var stack1 = Stack<String>()

    var stack2 = Stack<String>()

    fun appendTail(item: String) {
        stack1.push(item)
    }

    fun deleteHead() {
        if (stack2.empty()) {
            if(stack1.empty()){
                println("队列中没有数据了~")
                return
            }
            while (!stack1.empty()) {
                stack2.push(stack1.pop())
            }
        }
        println("出队   ${stack2.pop()}")

    }
}