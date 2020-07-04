package com.testmodule.dailypractice.队列

/**
 * @author  changePosition
 * @date  2020/1/28/028 23:54
 */

fun main() {
    var myQueue = MyQueue()
    for (i in 0 until 15) {
        myQueue.add(i)
    }
    var iterator = myQueue.queue.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }
}

class MyQueue {

    var queue = arrayOfNulls<Int>(10)
    // front指向
    var front = -1
    var rear = 0

    fun add(v: Int) {
        if (isFull()) {
            println("队列满了---")
            return
        }
        queue[rear++] = v
    }

    fun take(): Int? {
        if (isEmpty()) {
            throw Exception("队列为空")
        }
        return queue[front++]
    }

    fun isEmpty(): Boolean {
        if (front == rear) {
            return true
        }
        return false
    }

    fun isFull(): Boolean {
        if (rear == queue.size) {
            return true
        }
        return false
    }

}

class Pro冰箱
class Pro单开门冰箱
class Pro单开门2层冰箱
class Pro单开门3层冰箱
class Pro双开门冰箱
class Pro双开门2层冰箱
class Pro双开门3层冰箱
class ProTV
class Pro2KTV
class Pro2K液晶TV
class Pro2K超薄TV
class Pro4KTV
class Pro4K液晶TV
class Pro4K超薄TV

interface 抽象工厂 {
    fun create抽象冰箱(): 抽象冰箱工厂
    fun create抽象TV()
}

interface 抽象冰箱工厂 {
    fun create单开门(): 抽象单开门冰箱工厂
    fun create双开门(): 抽象双开门冰箱工厂
}

interface 抽象单开门冰箱工厂 {
    fun create2层单开门冰箱(): Pro单开门2层冰箱
    fun create3层单开门冰箱(): Pro单开门3层冰箱
}

interface 抽象双开门冰箱工厂 {
    fun create2层双开门冰箱(): Pro双开门2层冰箱
    fun create3层双开门冰箱(): Pro双开门3层冰箱
}

class 冰箱工厂 : 抽象单开门冰箱工厂, 抽象双开门冰箱工厂 {
    override fun create2层单开门冰箱(): Pro单开门2层冰箱 {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create3层单开门冰箱(): Pro单开门3层冰箱 {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create2层双开门冰箱(): Pro双开门2层冰箱 {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create3层双开门冰箱(): Pro双开门3层冰箱 {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

fun a() {
    var bx = 冰箱工厂()
    var pro单开门2层冰箱 = bx.create2层单开门冰箱()
}

interface ExportFactory {
    fun exportHeader()
    fun exportBody()
    fun exportFooter()

    fun export()
}

class ModelHeader
class ModelBody
class ModelFooter

class XmlFactory : ExportFactory {
    override fun exportHeader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun exportBody() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun exportFooter() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun export() {
        exportHeader()
        exportBody()
        exportFooter()
    }
}

class TestClient {
    fun t() {
        var factory:ExportFactory = XmlFactory()
        factory.export()
    }
}