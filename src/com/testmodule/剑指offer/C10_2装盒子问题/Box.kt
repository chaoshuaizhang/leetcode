package com.testmodule.剑指offer.C10_2装盒子问题

/**
 * @author  changePosition
 * @date  2020/4/19/019 16:02
 * 把一些长为2，宽为1的盒子，装到长为n，宽为2的容器里，共有多少种放法？
 */

fun main() {

    /*
    * 首先不管怎么放，盒子的总量肯定是n
    * 针对这个问题，我们可以只考虑盒子的一列
    * */
    val box = Box()
    println(box.addByWhile(1))
    println(box.addByWhile(2))
    println(box.addByWhile(3))
    println(box.addByWhile(4))
    println(box.addByWhile(5))
}

class Box {
    /*
    * 第n层竖着放，只放一块，假设除去第n块，已经有f(n-1)种放法
    * 第n层横着放，则需要占据n-2的空间，则除去后两块，有f(n-2)种放法
    * */
    fun add(n: Int): Int {
        if (n < 1) {
            return 0
        }
        if (n == 1) {
            return 1
        }
        if (n == 2) {
            return 2
        }
        return add(n - 2) + add(n - 1)
    }

    /*
    * 非递归实现
    * */
    fun addByWhile(n: Int): Int {
        if (n < 1) {
            return 0
        }
        if (n == 1) {
            return 1
        }
        if (n == 2) {
            return 2
        }

        var lastLast = 1
        var last = 2
        var cur = 0

        var l = n - 2
        while (l-- > 0) {
            cur = lastLast + last
            lastLast = last
            last = cur

        }
        return cur
    }

}