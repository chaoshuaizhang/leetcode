package com.testmodule.剑指offer.C10_斐波那契数列

/**
 * @author  changePosition
 * @date  2020/4/8/008 11:25
 */

fun main() {
    val fib = Fibonacci()

    var l = System.currentTimeMillis()
    println(fib.fib3(5))
    println(System.currentTimeMillis() - l)
    println("-------------")

    l = System.currentTimeMillis()
    println(fib.fib(5))
    println(System.currentTimeMillis() - l)

    println("-------------")
    l = System.currentTimeMillis()
    println(fib.fib2(1, 1, 1, 1))
    println(fib.fib2(1, 2, 1, 1))
    println(fib.fib2(1, 3, 1, 1))
    println(fib.fib2(1, 4, 1, 1))
    println(fib.fib2(1, 5, 1, 1))
    println(fib.fib2(1, 6, 1, 1))
    println(fib.fib2(1, 7, 1, 1))
    println(System.currentTimeMillis() - l)

}

class Fibonacci {
    /*
    * 递归实现
    * */
    fun fib(n: Long): Long {
        if (n < 1) {
            return 0
        }
        if (n == 1L) {
            return 1
        } else {
            return fib(n - 1) + fib(n - 2)
        }
    }

    /*
    * 优化：尾递归
    * 此处有Bug
    * */
    fun fib2(i: Long, n: Long, last: Long, curr: Long): Long {
        if (n == 1L || n == 2L) {
            return 1L
        }
        if (i == n) {
            return curr
        } else {
            return fib2(i + 1, n, curr, curr + last)
        }
    }

    /*
    * while循环
    * */
    fun fib3(n: Long): Long {
        if (n < 1) {
            println("输入 $n 不合法")
            return 1
        }
        if (n == 1L || n == 2L) {
            return 1
        }
        var i = 0
        var p = 1L
        var k = 1L
        var t: Long = 0
        while (i++ < n - 2) {
            t = p + k
            p = k
            k = t
        }
        return t
    }
}