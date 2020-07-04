package com.testmodule.剑指offer.C10_1青蛙跳台阶

/**
 * @author  changePosition
 * @date  2020/4/8/008 22:56
 * 1. 第一次没有想起来解决方案
 * 2. 也可以变换为装盒子问题
 */

fun main() {
    /*
    * 求 有多少种跳法
    * */
    var frog = FrogJumpStep()
    println(frog.jump(4))
}

class FrogJumpStep {

    /*
    * 思路：
    * 假设有n阶，
    * 第一次跳1阶，则后边一共有f(n-1)种方式
    * 第一次跳2阶，则后边一共有f(n-2)种方式
    * 所以一共有 f(n-1) + f(n-2)种方式
    *
    * 也可以按照最后一跳来说：
    * 最后一跳跳1阶，则之前一共有f(n-1)种方式
    * 最后一跳跳2阶，则之前一共有f(n-2)种方式
    * ...
    * */
    fun jump(n: Int): Int {
        if (n < 1) {
            return 0
        }
        if (n == 1) {
            return 1
        }
        if (n == 2) {
            return 2
        }
        return jump(n - 2) + jump(n - 1)
    }

}