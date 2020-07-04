package com.testmodule.剑指offer.C05_替换字符串中的空格

/**
 * @author  changePosition
 * @date  2020/3/11/011 13:14
 */
class ReplaceStrWhiteBlank {
    companion object {

        /*
        * 替换字符串中的空格为%20
        * 类型1：数组大小是固定的，长度正好是str.length
        * */
        fun replaceInNewArray(str: String): String {
            var count = 0
            for (i in str.indices) {
                if (str[i] == ' ') {
                    count++
                }
            }
            var strArr = arrayOfNulls<Char>(str.length + count * 2)
            count = 0
            for (i in str.indices) {
                if (str[i] == ' ') {
                    strArr[count++] = '%'
                    strArr[count++] = '2'
                    strArr[count++] = '0'
                } else {
                    strArr[count++] = str[i]
                }
            }

            for (i in strArr.indices) {
                print("${strArr[i]}")
            }

            return ""
        }

        /*
        * 原数组大小是无限的，有无限的多余空间
        * */
        fun replaceInOldArray(str: Array<Char?>) {
            var count = 0
            var index = 0
            for (i in str.indices) {
                if (str[i] == ' ') {
                    count += 2
                } else if (str[i] == null) {
                    if (count == 0) {
                        println("没有空格")
                        return
                    } else {
                        count += i
                        index = i - 1
                        break
                    }
                }
            }
            // 倒序
            for (i in index downTo 0) {
                if (str[i] == ' ') {
                    str[--count] = '0'
                    str[--count] = '2'
                    str[--count] = '%'
                } else {
                    str[--count] = str[i]
                }
            }
            for (i in str.indices) {
                print("${str[i]}")
            }
        }

        /*
        * 归并有序数组A、数组B到数组A中，A的大小是无限的
        * 思路：先把数组A全部往后移动B的长度，然后再进行归并
        * */
        fun addArrayB2ArrayA(arrA: Array<Int?>, arrB: Array<Int>) {
            var aLength = 0
            for (i in arrA.indices) {
                if (arrA[i] == null) {
                    aLength = i - 1
                    break
                }
            }
            for (i in aLength downTo 0) {
                arrA[i + arrB.size] = arrA[i]
            }

            // 开始归并
            var pi = 0
            var pj = arrB.size
            var p = 0
            while (pi < arrB.size && pj < arrA.size) {
                if (arrB[pi] < arrA[pj]!!) {
                    arrA[p++] = arrB[pi++]
                } else if (arrB[pi] == arrA[pj]) {
                    arrA[p++] = arrA[pj++]
                    arrA[p++] = arrB[pi++]
                } else {
                    arrA[p++] = arrA[pj++]
                }
            }
            if (pi < arrB.size) {
                while (pi < arrB.size) {
                    arrA[p++] = arrB[pi++]
                }
            } else if (pj < arrA.size) {
                while (pj < arrA.size) {
                    arrA[p++] = arrA[pj++]
                }
            }

            for (i in arrA.indices) {
                if (arrA[i] == null) {
                    break
                }
                println(arrA[i])
            }
        }


    }
}

fun main() {
    // println(ReplaceStrWhiteBlank.replaceInNewArray("AF SD 12345 8"))
    var array = arrayOfNulls<Char>(5)
    array[0] = ' '
    array[1] = 'A'
    array[2] = ' '
    array[3] = 'A'
    array[4] = 'A'
//    array[5] = ' '
//    array[6] = ' '
//    array[7] = 'A'
//    array[8] = ' '
//    array[9] = ' '
//    println(ReplaceStrWhiteBlank.replaceInOldArray(array))

    for (i in array.indices) {
        println("-----     $i")
    }

    var arrA = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, null, null, null, null)
    var arrB = arrayOf(-1, 1, 3, 4)

    ReplaceStrWhiteBlank.addArrayB2ArrayA(arrA, arrB)

}