package com.testmodule.剑指offer.C11

/**
 * @author  changePosition
 * @date  2020/4/19/019 17:49
 */

fun main() {
    var arr = arrayOf(7, 3, 9, 12, 52, 1, 4, -7, 35, 27, 32)
    var quickSort = QuickSort()
    quickSort.quickSort(arr, 0, arr.size - 1)
    for (i in arr.indices) {
        print("${arr[i]}  ")
    }
}

class QuickSort {
    fun quickSort(array: Array<Int>, low: Int, height: Int) {
        if(low >= height) return
        // 当前数组的头尾
        var lowTmp = low
        var heightTmp = height
        // 定义基准元素值
        var base = array[lowTmp]
        // 定于基准元素位置
        var tmp = lowTmp
        while (lowTmp < heightTmp) {
            while (lowTmp < heightTmp && base <= array[heightTmp]) {
                heightTmp--
            }
            if (base > array[heightTmp]) {
                // 交换位置
                array[tmp] = array[heightTmp]
                tmp = heightTmp
            }
            while (lowTmp < heightTmp && base >= array[lowTmp]) {
                lowTmp++
            }
            if (base < array[lowTmp]) {
                // 交换位置
                array[tmp] = array[lowTmp]
                tmp = lowTmp
            }
            // 恢复基准值
            array[tmp] = base
        }
        // 注意第三个参数 height，不要写成heightTmp
        quickSort(array, low, tmp-1)
        quickSort(array, tmp+1, height)
    }
}