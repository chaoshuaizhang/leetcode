package com.testmodule.剑指offer.C04_二维数组中的查找

import java.lang.reflect.Type
import java.net.Proxy
import java.util.*

/**
 * @author  changePosition
 * @date  2020/3/4/004 1:01
 */

fun main() {
    val search = SearchInDupliateArray()
    val arr = arrayOfNulls<Array<Int>>(2)
    arr[0] = arrayOf(1, 3, 5, 6, 7)
    arr[1] = arrayOf(3, 5, 8, 9, 11)
    search.test(arr, 8)
}

class SearchInDupliateArray {

    // 思路1：先按顺序从前往后找，找到边界还未
    // 找到时，判断一下大小，然后直接从第二行
    // 边界开始从后往前找，从后往前找是一个递归调用
    //
    // 思路还是对的，但是实现方式有点复杂，其实想想
    // 是不是只需要那个递归就行了，直接从后往前找，
    // 并且可以把递归换成while循环的形式
    /*
    * 从前往后找
    * */
    fun test(arr: Array<Array<Int>?>, num: Int) {
        for (i in arr.indices) {
            for (j in arr[i]!!.indices) {
                if (arr[i]!![j] == num) {
                    println("找到了 $num")
                    return
                } else if (arr[i]!![j] > num) {
                    if (j == 0) {
                        println("不包含")
                        return
                    } else {
                        if (j == arr[i]!!.size - 1) {
                            testLastDown(arr, i + 1, j - 1, num)
                            return
                        } else {
                            // 开始从左边位置的下一个位置 倒着找
                            println("不包含")
                            return
                        }
                    }
                } else if (arr[i]!![j] < num) {
                    // 不处理
                    if (i == arr.size - 1 && j == arr[i]!!.size - 1) {
                        println("不包含")
                        return
                    }
                    if (i < arr.size - 1 && j == arr[i]!!.size - 1) {
                        testLastDown(arr, i + 1, j, num)
                        return
                    }
                }
            }
        }
    }

    /*
    * 从后往前找
    * */
    private fun testLastDown(arr: Array<Array<Int>?>, i: Int, j: Int, num: Int) {
        if (arr[i]!![j] > num) {
            var s = arr.size
            if (j == 0 || i == s - 1) {
                println("不包含")
                return
            } else {
                testLastDown(arr, i, j - 1, num)
                return
            }
        } else if (arr[i]!![j] == num) {
            println("arr[$i][$j]")
            return
        } else {
            if (i == arr.size - 1) {
                println("不包含")
                return
            } else {
                testLastDown(arr, i + 1, j, num)
                return
            }
        }
    }

}