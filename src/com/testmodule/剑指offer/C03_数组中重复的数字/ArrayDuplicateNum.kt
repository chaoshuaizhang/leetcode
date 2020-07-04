package com.testmodule.剑指offer.C03_数组中重复的数字

/**
 * @author  changePosition
 * @date  2020/3/3/003 0:00
 */

fun main() {
    var arr = arrayOf(9, 0, 3, 4, 5, 2, 4, 7, 1, 4, 6, 6, 4, 5, 6);
    var arrayDuplicateNum = ArrayDuplicateNum()
    arrayDuplicateNum.test2(arr)
}

class ArrayDuplicateNum {
    /*
    * 长度为n的数组，里边存放了0 - n-1之间的数，求出重复的数
    * */
    fun test1(arr: Array<Int>) {
        for (i in arr.indices) {
            if (arr[i] == i) {
                continue
            }
            if (arr[i] == arr[arr[i]]) {
                println("重复 ${arr[i]}")
            } else {
                var tmp = arr[i]
                arr[i] = arr[tmp]
                arr[tmp] = tmp
            }
        }
    }

    /*
    * 长度为n+1的数组，里边存放了1 - n之间的数字，在不修改数组的情况下，
    * 求出任意一个重复元素即可
    *
    * ★★★★★
    * */
    fun test2(arr: Array<Int>) {
        var n = arr.size - 1
        var left = 0
        var right = n
        while (left <= right) {
            var m = (left + right) / 2
            var count = 0
            for (i in 0 until arr.size) {
                if (left <= arr[i] && arr[i] <= m) {
                    count++
                }
            }
            if (count > (m - left + 1)) {
                // left=right的情况下，并且count>1，说明肯定重复
                // 对于 left == m是在调试时发现的，也会有这种情况
                //if(left == right || left == m){
                if (left == right) {
                    print(m)
                    break
                }
                right = m
            } else {
                left = m + 1
            }
        }
    }
}